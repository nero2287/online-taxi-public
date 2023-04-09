package com.taxi.price.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceRole {
    /**
     * 城市编号
     */
    private String cityCode;
    /**
     * 车俩类型
     */
    private int vehicleType;
    /**
     * 起步价
     */
    private double startFare;
    /**
     * 起步里程
     */
    private int startMile;
    /**
     * 起步时长
     */
    private double startMinute;
    /**
     * 公里计程单价
     */
    private double unitPricePerMile;
    /**
     * 时间计程单价
     */
    private double unitPricePerMinute;


}
