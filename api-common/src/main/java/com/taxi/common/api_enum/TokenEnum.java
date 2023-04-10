package com.taxi.common.api_enum;

public enum TokenEnum {
    PHONE("phone"),

    IDENTIFY("identify"),

    TIMESTAMP("timeStamp"),

    TOKENTYPE("tokenType")

    ;

    private String name;

    TokenEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
