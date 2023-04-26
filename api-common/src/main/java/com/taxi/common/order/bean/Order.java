package com.taxi.common.order.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private long orderId;

    /**
     * 乘客di
     */
    private long passengerId;
    /**
     * 乘客手机号
     */
    private String passengerPhone;
    /**
     * 驾驶员id
     */
    private long driverId;
    /**
     * 驾驶员手机号
     */
    private String driverPhone;
    /**
     * 车辆id
     */
    private long vehicleId;
    /**
     * 车辆类型
     */
    private String vehicleType;
    /**
     * 行政地区
     */
    private String address;
    /**
     * 下单时间
     */
    private LocalDateTime orderTime;
    /**
     * 乘客备注
     */
    private String passengerNote;
    /**
     * 预计到达时间
     */
    private LocalDateTime departTime;
    /**
     * 目的地
     */
    private String departure;
    /**
     * 出发地经度
     */
    private String depLongitude;
    /**
     * 出发地纬度
     */
    private String depLatitude;
    /**
     * 目的地
     */
    private String destination;
    /**
     * 目的地经度
     */
    private String destLongitude;
    /**
     * 目的地经度
     */
    private String destLatitude;
    /**
     * 定位加密标识 默认：WGS84
     */
    private int encrypt;
    /**
     * 运价类型id
     */
    private int fareType;
    /**
     * 运价版本
     */
    private int pareVersion;
    /**
     * 驾驶员接单时车辆经度
     */
    private String receiveOrderCarLongitude;
    /**
     * 驾驶员接单时车辆纬度
     */
    private String receiveOrderCarLatitude;
    /**
     * 机动车驾驶证号
     */
    private String licenseId;
    /**
     * 机动车牌照
     */
    private String vehicleNo;
    /**
     * 出发接乘客的时间
     */
    private String toPickUpPassengerTime;
    /**
     * 出发接乘客时车辆经度
     */
    private String toPickUpPassengerLongitude;
    /**
     * 出发接乘客时车辆的纬度
     */
    private String toPickUpPassengerLatitude;
    /**
     * 出发接乘客时车辆所处地区
     */
    private String toPickUpPassengerAddress;
    /**
     *  驾驶员到达乘客上车点时间
     */
    private LocalDateTime driverArrivedDepartureTime;
    /**
     * 乘客上车时间
     */
    private LocalDateTime pickUpPassengerTime;
    /**
     * 乘客上车时的经度
     */
    private String pickUpPassengerLongitude;
    /**
     * 乘客上车时的纬度
     */
    private String pickUpPassengerLatitude;
    /**
     * 乘客下车时间
     */
    private LocalDateTime passengerGetOffTime;
    /**
     * 乘客下车时的经度
     */
    private String passengerGetOffLongitude;
    /**
     * 乘客下车时的纬度
     */
    private String passengerGetOffLatitude;
    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;
    /**
     * 取消发起人
     */
    private int cancelOperator;
    /**
     * 取消类型代码
     */
    private int cancelTypeCode;
    /**
     * 载客里程  米
     */
    private double driveMile;
    /**
     * 载客里程  分
     */
    private double driverTime;
    /**
     * 订单类型
     */
    private int orderType;
    /**
     * 订单状态
     */
    private int orderStatus;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
