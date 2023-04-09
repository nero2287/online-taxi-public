package com.taxi.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.taxi.common.api_enum.TokenEnum;
import com.taxi.common.api_enum.TokenIdentify;
import com.taxi.common.bean.DoubleToken;
import com.taxi.common.bean.TokenBean;
import com.taxi.common.bean.TokenConstant;

import java.util.Calendar;
import java.util.Date;

public class TokenUtil {
    private static final String SIGN = "taxi_head_3867115_&)%";
    /**
     * 生成token
     * @param tokenBean
     * @return
     */
    public static String createToken(TokenBean tokenBean,String tokenType){
        /*
        日历生成过期时间
        //获取日历
        Calendar calendar = Calendar.getInstance();
        //设置过期时间
        calendar.add(Calendar.DATE, TokenConstant.PASSENGER_ACCESS_EXCEED);
        //将日历转化为时间
        Date date = calendar.getTime();
         */

        //JWT生成器
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(TokenEnum.PHONE.getName(),tokenBean.getPhone());
        builder.withClaim(TokenEnum.IDENTIFY.getName(),tokenBean.getIdentify());
        builder.withClaim(TokenEnum.TOKENTYPE.getName(),tokenType);
        builder.withClaim(TokenEnum.TIMESTAMP.getName(),Calendar.getInstance().getTime().toString());

        //整合过期时间
//        builder.withExpiresAt(date);
        return builder.sign(Algorithm.HMAC256(SIGN));
    }

    /**
     *
     * @param tokenBean
     * @return
     */
    public static DoubleToken createDoubleToken(TokenBean tokenBean){
        DoubleToken doubleToken = new DoubleToken();
        doubleToken.setAccess_token(createToken(tokenBean,"access_token"));
        doubleToken.setRefresh_token(createToken(tokenBean,"refresh_token"));
        return doubleToken;
    }

    public static TokenBean decodeToken(String token) throws SignatureVerificationException,TokenExpiredException,AlgorithmMismatchException{
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        int identify = verify.getClaim(TokenEnum.IDENTIFY.getName()).asInt();
        TokenBean tokenBean = new TokenBean();
        if(identify == TokenIdentify.PASSENGER.getCode()){
            tokenBean.setPhone(verify.getClaim(TokenEnum.PHONE.getName()).asString());
        }else if(identify == TokenIdentify.DRIVER.getCode()){
            tokenBean.setPhone(verify.getClaim(TokenEnum.PHONE.getName()).asString());
        }
        tokenBean.setIdentify(identify);

        return tokenBean;
    }
}
