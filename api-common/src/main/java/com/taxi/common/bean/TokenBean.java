package com.taxi.common.bean;

import lombok.Data;

@Data
public class TokenBean {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份
     */
    private int identify;

    /**
     * token类型
     */
    private String tokenType;

    /**
     * 时间类型
     */
    private String timeStamp;
}
