package com.taxi.common.bean;

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

    /**
     * 所在城市编号
     */
    private String city_code;
}
