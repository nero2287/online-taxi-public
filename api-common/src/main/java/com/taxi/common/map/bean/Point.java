package com.taxi.common.map.bean;

import lombok.Data;

@Data
public class Point {
    private String ak;
    private long service_id;
    private String entity_name;
    //纬度
    private double latitude;
    //经度
    private double longitude;
    private String locTime;
    private String coordTypeInput;
}
