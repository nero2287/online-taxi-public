package com.taxi.common.driver.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleBinding {
    private long bindingState;
    private LocalDateTime bindingTime;
    private long driverId;
    private LocalDateTime unbindingTime;
    private long vehicleId;
}
