package com.taxi.passenger.intercepetor;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");
        String message = "";
        boolean flag =true;
        try{
            String redis_access_token = "";
            TokenBean tokenBean = TokenUtil.decodeToken(token);
            String passengerPhone = tokenBean.getPassengerPhone();
            int identify = tokenBean.getIdentify();
            if(identify == TokenIdentify.PASSENGER.getCode()){
                redis_access_token = stringRedisTemplate.opsForValue().get(TokenConstant.PASSENGER_ACCESS_TOKEN_PREFIX+passengerPhone);
            }
            if(StringUtils.isBlank(redis_access_token)){
                throw new TokenExpiredException("");
            }else if(!redis_access_token.equals(token)){
                throw new Exception();
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

        if(!flag){
            response.setContentType("text/html;charset = utf-8");
            PrintWriter out = response.getWriter();
            out.println(JSONObject.toJSONString(JsonResult.error(message)));
        }

        return flag;
    }
}
