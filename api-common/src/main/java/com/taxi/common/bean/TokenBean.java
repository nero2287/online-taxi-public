package com.taxi.common.bean;

import lombok.Data;

@Data
public class TokenBean {

    private String passengerPhone;

    private int identify;

    private String tokenType;

    private String timeStamp;

}
