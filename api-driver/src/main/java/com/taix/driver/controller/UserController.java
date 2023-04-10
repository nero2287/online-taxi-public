package com.taix.driver.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taix.driver.service.DriverService;
import com.taix.driver.service.UserService;
import com.taix.driver.service.VerificationService;
import com.taxi.common.bean.DoubleToken;
import com.taxi.common.bean.TokenBean;
import com.taxi.common.bean.TokenConstant;
import com.taxi.common.util.JsonResult;
import com.taxi.common.util.TokenUtil;
import jdk.nashorn.internal.parser.Token;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    public final String DRIVER_VERIFICATION_PREFIX = "api-driver-verification-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private VerificationService verificationService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;

    @GetMapping("/verification_code")
    public JsonResult login(String driverPhone){
        //验证驾驶员是否存在
        boolean object = new ObjectMapper().convertValue(driverService.checkUser(driverPhone).getData(),boolean.class);
        if(object){
            //存在
            String verification_repeat = DRIVER_VERIFICATION_PREFIX+driverPhone+"-repeat";
            //检查验证码是否重复发送
            String verification_code = stringRedisTemplate.opsForValue().get(verification_repeat);
            if(StringUtils.isBlank(verification_code)){
                //获取验证码
                verification_code =verificationService.getVerification().getData()+"";
                //存入redis
                stringRedisTemplate.opsForValue().set(DRIVER_VERIFICATION_PREFIX+driverPhone,verification_code,30, TimeUnit.MINUTES);
                //重复发送计时
                stringRedisTemplate.opsForValue().set(verification_repeat,driverPhone,1,TimeUnit.MINUTES);
            }else{
                return JsonResult.tip("操作频繁，请稍后再试。");
            }

            System.out.println(verification_code);
        }else{
            //不存在
            return JsonResult.fail("驾驶员不存在，无法登录。请联系管理员。");
        }
        return JsonResult.success();
    }

    @PostMapping("/login")
    public JsonResult login_check(String driverPhone,String verification_code){
        if(StringUtils.isBlank(verification_code)){
            return JsonResult.error("验证码不能为空");
        }else if(StringUtils.isBlank(driverPhone)){
            return JsonResult.error("手机号不能为空");
        }
        //从redis获取验证码
        String redis_verification = stringRedisTemplate.opsForValue().get(DRIVER_VERIFICATION_PREFIX+driverPhone);
        if(StringUtils.isBlank(redis_verification)){
            return JsonResult.error("请使用尾号"+driverPhone.substring(7,11)+"发送验证码");
        }

        if(redis_verification.equals(verification_code)){
            String redisKey = DRIVER_VERIFICATION_PREFIX+driverPhone;
            String redisKeyRepeat = DRIVER_VERIFICATION_PREFIX+driverPhone+"repeat";
            List<String> redisKeyList = new ArrayList<>();
            redisKeyList.add(redisKey);
            redisKeyList.add(redisKeyRepeat);
            //注册和登录
            if(new ObjectMapper().convertValue(driverService.checkUser(driverPhone).getData(),boolean.class)) {
                //登录
                DoubleToken doubleToken = userService.login(driverPhone);
                stringRedisTemplate.opsForValue().set(TokenConstant.DRIVER_ACCESS_TOKEN_PREFIX+driverPhone,doubleToken.getAccess_token(), TokenConstant.ACCESS_EXCEED,TimeUnit.DAYS);
                stringRedisTemplate.opsForValue().set(TokenConstant.DRIVER_REFRESH_TOKEN_PREFIX+driverPhone,doubleToken.getRefresh_token(),TokenConstant.REFRESH_EXCEED,TimeUnit.DAYS);
                //删除redis中的验证码
                stringRedisTemplate.delete(redisKeyList);
                return JsonResult.success().put("token",doubleToken);
            }
        }else{
            JsonResult.fail("验证码错误");
        }
        //用户无法登录
        return JsonResult.fail("无法登录，请联系管理员");
    }

    @GetMapping("/refresh_token")
    public JsonResult refresh(String refresh_token){
        String message = "";
        TokenBean tokenBean = null;
        DoubleToken doubleToken = null;
        boolean flag = true;
        try{
            tokenBean = TokenUtil.decodeToken(refresh_token);
            String refreshToken = stringRedisTemplate.opsForValue().get(TokenConstant.DRIVER_REFRESH_TOKEN_PREFIX+tokenBean.getPhone());
            if(StringUtils.isBlank(refreshToken)){
                return JsonResult.fail("token已过期");
            }
            boolean is_exist = new ObjectMapper().convertValue(driverService.checkUser(tokenBean.getPhone()).getData(),boolean.class);
            if(refreshToken.equals(refresh_token)&&is_exist){
                //生成新的token
                doubleToken = TokenUtil.createDoubleToken(tokenBean);
                stringRedisTemplate.delete(TokenConstant.DRIVER_REFRESH_TOKEN_PREFIX+tokenBean.getPhone());
                stringRedisTemplate.opsForValue().set(TokenConstant.DRIVER_ACCESS_TOKEN_PREFIX+tokenBean.getPhone(),doubleToken.getAccess_token(),TokenConstant.ACCESS_EXCEED,TimeUnit.DAYS);
                stringRedisTemplate.opsForValue().set(TokenConstant.DRIVER_REFRESH_TOKEN_PREFIX+tokenBean.getPhone(),doubleToken.getRefresh_token(),TokenConstant.REFRESH_EXCEED,TimeUnit.DAYS);
            }

        }catch (SignatureVerificationException e){
            message = "token签名错误";
            flag = false;
        }catch (TokenExpiredException e){
            message = "token过期";
            flag = false;
        }catch (AlgorithmMismatchException e){
            message = "token算法异常";
            flag = false;
        }catch (Exception e){
            message = "token无效";
            flag = false;
        }


        if(flag){
            return JsonResult.success().put("token",doubleToken);
        }else{
            return JsonResult.success(message);
        }



    }
}
