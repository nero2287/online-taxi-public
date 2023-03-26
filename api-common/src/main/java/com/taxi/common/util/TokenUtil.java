package com.taxi.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class TokenUtil {

    private static final String SIGN = "taxi_head_3867115_&)%";

    private static final int EXCEED = 30;


    /**
     * 生成token
     * @param map
     * @return
     */
    public String createToken(Map<String,String> map){
        //获取日历
        Calendar calendar = Calendar.getInstance();
        //设置过期时间
        calendar.add(Calendar.DATE,EXCEED);
        //将日历转化为时间
        Date date = calendar.getTime();
        //JWT生成器
        JWTCreator.Builder builder = JWT.create();
        //整合map
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //整合过期时间
        builder.withExpiresAt(date);
        return builder.sign(Algorithm.HMAC256(SIGN));
    }

}
