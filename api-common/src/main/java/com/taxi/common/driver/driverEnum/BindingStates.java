package com.taxi.common.driver.driverEnum;

public enum BindingStates {

    BIND(1,"binding"),

    UNBIND(2,"unbinding"),

    ;

    private int code;

    private String value;

    BindingStates(int code,String value){
        this.code=code;
        this.value=value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
