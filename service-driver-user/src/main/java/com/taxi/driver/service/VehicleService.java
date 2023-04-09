package com.taxi.driver.service;

import com.taxi.common.driver.bean.Vehicle;
import com.taxi.common.driver.bean.VehicleBinding;

public interface VehicleService {
    boolean bind(VehicleBinding vehicleBinding);
    boolean vehicle(Vehicle vehicle);
}
