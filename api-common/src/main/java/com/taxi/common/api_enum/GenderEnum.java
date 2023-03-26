package com.taxi.common.api_enum;

public enum GenderEnum {

    MALE(1,"男性"),

    FEMALE(2,"女性"),

    WALMART_BAG(3,"沃尔玛塑料袋")

    ;
    
    private int key;
    private String value;

    GenderEnum(int key,String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
