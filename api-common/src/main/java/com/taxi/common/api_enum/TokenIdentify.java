package com.taxi.common.api_enum;

public enum TokenIdentify {

    PASSENGER(1,"passenger"),

    DRIVER(2,"driver")

    ;

    private int code;
    private String identify;

    TokenIdentify(int code,String identify){
        this.code  = code;
        this.identify = identify;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
}
