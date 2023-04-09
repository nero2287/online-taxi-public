package com.taxi.common.driver.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DriverStates {
    private long driverId;
    private int state;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
