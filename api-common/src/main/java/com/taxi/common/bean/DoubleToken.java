package com.taxi.common.bean;

import lombok.Data;

@Data
public class DoubleToken {
    private String access_token;
    private String refresh_token;
}
