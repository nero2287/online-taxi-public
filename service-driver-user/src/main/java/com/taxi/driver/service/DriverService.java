package com.taxi.driver.service;

import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.DriverStates;

public interface DriverService {
    boolean putDriver(Driver driver);

    Driver checkUser(String driverPhone);

    boolean editStatus(DriverStates driverStates);
}
