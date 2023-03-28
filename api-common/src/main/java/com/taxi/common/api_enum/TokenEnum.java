package com.taxi.common.api_enum;

public enum TokenEnum {

    PASSENGERPHONE("passengerPhone")

    ;

    private String name;

    TokenEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
