package com.taxi.common.driver.bean;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Vehicle {
    //主键
    private long id;
    //车辆所在城市
    private String address;
    //车牌号
    private String vehicleNo;
    //服务端id
    private int serviceId;
    //终端名称
    private String entityName;
    //车牌颜色
    private int plateColor;
    //载客量
    private int seats;
    //车辆厂牌
    private String brand;
    //车辆型号
    private String model;
    //车辆类型
    private String vehicleType;
    //车辆所有人
    private String ownerName;
    //车辆颜色
    private int vehicleColor;
    //发动机号
    private String engineId;
    //vin
    private String vin;
    //车辆注册日期
    private LocalDate certifyDate;
    //燃料类型
    private int fuelType;
    //发动机排量
    private int engineDisplace;
    //车辆运输证发证机构
    private String transAgency;
    //车辆经营区域
    private String transArea;
    //运输证有效期
    private LocalDate transDateStart;
    //运输证有效期截止
    private LocalDate transDateStop;
    //车辆初次登记日期
    private LocalDate certifyDateB;
    //车辆检修状态
    private int fixState;
    //车辆年审状态
    private int checkState;
    //发票打印设备序列号
    private String feePrintId;
    //卫星定位装置品牌
    private String gpsBrand;
    //卫星定位装置型号
    private String gpsModel;
    //卫星定位安装日期
    private LocalDate gpsInstallDate;
    //报备日期
    private LocalDate registerDate;
    //服务类型
    private int commercialType;
    //运价类型
    private int fareType;
    //状态
    private int state;
    //操作标识
    private int flag;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}
