package com.taxi.common.bean;

public class TokenConstant {

    /**
     * 乘客accessToken前缀
     */
    public static final String PASSENGER_ACCESS_TOKEN_PREFIX = "access-token-passenger-";

    /**
     * 乘客refreshToken前缀
     */
    public static final String PASSENGER_REFRESH_TOKEN_PREFIX = "refresh-token-passenger-";

    /**
     * 乘客AccessToken过期时间
     */
    public static final int PASSENGER_ACCESS_EXCEED = 15;

    /**
     * 乘客RefresshToken过期时间
     */
    public static final int PASSENGER_REFRESH_EXCEED = 30;

}
