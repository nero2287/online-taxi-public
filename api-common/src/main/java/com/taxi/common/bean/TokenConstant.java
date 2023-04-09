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
     * 驾驶员accessToken前缀
     */
    public static final String DRIVER_ACCESS_TOKEN_PREFIX = "access-token-driver-";

    /**
     * 驾驶员refreshToken前缀
     */
    public static final String DRIVER_REFRESH_TOKEN_PREFIX = "refresh-token-driver-";

    /**
     * 乘客AccessToken过期时间
     */
    public static final int ACCESS_EXCEED = 15;

    /**
     * 乘客RefresshToken过期时间
     */
    public static final int REFRESH_EXCEED = 30;

}
