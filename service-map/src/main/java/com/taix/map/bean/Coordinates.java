package com.taix.map.bean;

import lombok.Data;

@Data
public class Coordinates {
    /**
     * 起点经度
     */
    private String depLongitude;
    /**
     * 起点纬度
     */
    private String depLatitude;
    /**
     * 终点经度
     */
    private String destLongitude;
    /**
     * 终点纬度
     */
    private String destLatitude;

}
