package com.taxi.common.driver.driverEnum;

public enum WorkState {

    STOP(0,"收车"),
    WORKING(1,"接单"),
    PAUSE(2,"暂停接单")

    ;

    private int code;
    private String value;

    WorkState(int code, String value){
        this.code = code;
        this.value = value;
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
