package com.taxi.common.api_enum;

public enum ResponseStatusEnum {

    SUCCESS(200,"success"),

    FAIL(300,"fail"),

    ERROR(500,"系统错误"),

    TIP(100,"系统提示"),
    ;

    private int code;
    private String message;

    ResponseStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
