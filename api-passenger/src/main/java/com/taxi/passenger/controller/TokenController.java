package com.taxi.passenger.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.taxi.common.api_enum.TokenIdentify;
import com.taxi.common.bean.DoubleToken;
import com.taxi.common.bean.TokenBean;
import com.taxi.common.bean.TokenConstant;
import com.taxi.common.util.JsonResult;
import com.taxi.common.util.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/refresh_token")
    public JsonResult refreshToken(@RequestBody DoubleToken doubleToken){
        String message = "";
        boolean flag = true;
        TokenBean tokenBean = new TokenBean();
        String refresh_token = doubleToken.getRefresh_token();
        try{
            //解析token
            tokenBean = TokenUtil.decodeToken(refresh_token);
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

        if(!flag){
            return JsonResult.error(message);
        }else{
            boolean login_exceed = false;
            if(tokenBean.getIdentify()== TokenIdentify.PASSENGER.getCode()){
                //从redis获取refreshToken
                String redis_refresh_token = stringRedisTemplate.opsForValue().get(TokenConstant.PASSENGER_REFRESH_TOKEN_PREFIX+tokenBean.getPhone());
                if(StringUtils.isBlank(redis_refresh_token)){
                    login_exceed = true;
                }else{
                    //重新生成双token
                    DoubleToken new_doubleToken = TokenUtil.createDoubleToken(tokenBean);
                    //刷新redis中的token
                    stringRedisTemplate.opsForValue().set(TokenConstant.PASSENGER_REFRESH_TOKEN_PREFIX+tokenBean.getPhone(),new_doubleToken.getRefresh_token());
                    stringRedisTemplate.opsForValue().set(TokenConstant.PASSENGER_ACCESS_TOKEN_PREFIX+tokenBean.getPhone(),new_doubleToken.getAccess_token());
                    return JsonResult.success(new_doubleToken);
                }
            }
            if(login_exceed){
                return JsonResult.fail("登录信息超时，请重新登录");
            }else{
                return JsonResult.error();
            }
        }
    }
}
