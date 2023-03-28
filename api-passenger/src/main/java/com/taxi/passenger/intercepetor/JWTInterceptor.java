package com.taxi.passenger.intercepetor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.taxi.common.util.JsonResult;
import com.taxi.common.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");
        String message = "";
        boolean flag =true;
        try{
            TokenUtil.decodeToken(token);
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
            PrintWriter out = response.getWriter();
            out.println(JsonResult.error(message));
        }

        return flag;
    }
}
