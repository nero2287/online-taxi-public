package com.taxi.passenger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxi.common.api_enum.TokenEnum;
import com.taxi.common.api_enum.TokenIdentify;
import com.taxi.common.bean.DoubleToken;
import com.taxi.common.bean.TokenConstant;
import com.taxi.common.util.JsonResult;
import com.taxi.common.util.TokenUtil;
import com.taxi.passenger.service.PassengerUserService;
import com.taxi.passenger.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class ApiPassengerController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private VerificationService verificationService;
    @Autowired
    private PassengerUserService passengerUserService;

    /**
     * 乘客验证码前缀
     */
    public final static String PASSENGER_TOKEN_PREFIX = "api-passenger-verification-";

    /**
     * 发送验证码
     * @param passengerPhone
     * @return
     */
    @GetMapping("/verification_code")
    public JsonResult getVerification_code(String passengerPhone){
        if(passengerPhone==null||passengerPhone.equals("")){
            return JsonResult.error("手机号不能为空");
        }
        //生成redis键值
        String redis_key = PASSENGER_TOKEN_PREFIX+passengerPhone;
        //验证码重发键值
        String repeat_key = PASSENGER_TOKEN_PREFIX+passengerPhone+"-repeat";
        //检查验证码是否重复发送
        String repeat_value= stringRedisTemplate.opsForValue().get(repeat_key);
        if(repeat_value!=null){
            return JsonResult.tip("操作频繁，请稍后再试。");
        }
        String code = verificationService.getVerification_code().getData()+"";//从服务端获取验证码
        System.out.println(code);
        //存入redis并且保存30分钟
        stringRedisTemplate.opsForValue().set(redis_key,code,30, TimeUnit.MINUTES);
        //验证码重发计时
        stringRedisTemplate.opsForValue().set(repeat_key,passengerPhone,1, TimeUnit.MINUTES);
        //通过通讯运营商API发送到用户手机
        return JsonResult.success();
    }


    /**
     * 验证验证码
     * @param passengerPhone
     * @param verification_code
     * @return
     */
    @PostMapping("/verification_code_check")
    public JsonResult checkVerificationCode(String passengerPhone,String verification_code){
        String redis_key = PASSENGER_TOKEN_PREFIX+passengerPhone;
        String redis_code = stringRedisTemplate.opsForValue().get(redis_key);
        if(redis_code==null){
            return JsonResult.error("请使用尾号"+passengerPhone.substring(7,11)+"发送验证码");
        }
        if(redis_code.equals(verification_code)){
            //验证码通过
            List<String> redisKeyList = new ArrayList<>();
            redisKeyList.add(PASSENGER_TOKEN_PREFIX+passengerPhone);
            redisKeyList.add(PASSENGER_TOKEN_PREFIX+passengerPhone+"repeat");
            //查询数据库是否需存在该用户
//            Object doubleToken = passengerUserService.checkUser(passengerPhone).getData();
//            DoubleToken aa = new ObjectMapper().convertValue(doubleToken,DoubleToken.class);
            DoubleToken doubleToken = new ObjectMapper().convertValue(passengerUserService.checkUser(passengerPhone).getData(),DoubleToken.class);
            //将token存入redis
            stringRedisTemplate.opsForValue().set(TokenConstant.PASSENGER_ACCESS_TOKEN_PREFIX+passengerPhone,
                    doubleToken.getAccess_token(),TokenConstant.PASSENGER_ACCESS_EXCEED,TimeUnit.DAYS);
            stringRedisTemplate.opsForValue().set(TokenConstant.PASSENGER_REFRESH_TOKEN_PREFIX+passengerPhone,
                    doubleToken.getRefresh_token(),TokenConstant.PASSENGER_REFRESH_EXCEED,TimeUnit.DAYS);
            //删除redis中的验证码
            stringRedisTemplate.delete(redisKeyList);
            return JsonResult.success().put("token",doubleToken);
        }else{
            //验证码错误
            return JsonResult.fail("验证码错误,请使用尾号"+passengerPhone.substring(7,11)+"查看验证码");
        }
    }

    /**
     * 验证token
     */
    @GetMapping("/get")
    public JsonResult accessToken(){
        return JsonResult.success();
    }
}


