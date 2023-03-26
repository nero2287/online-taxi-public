package com.taxi.common.api_enum;

public enum AccountStatus {

    ACTIVATED(1,"启用"),

    ABANDON(2,"废弃")

    ;

    private int key;
    private String value;

    AccountStatus(int key,String value){
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
