package com.taix.manage.service;

import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.Vehicle;
import com.taxi.common.driver.bean.VehicleBinding;
import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient("driver-user")
public interface DriverUserService {
    @PostMapping("/driver/user")
    JsonResult addUser(@RequestBody Driver driver);
    @PutMapping("/driver/user")
    JsonResult updateUser(@RequestBody Driver driver);
    @PostMapping("/vehicle/info")
    JsonResult vehicle(@RequestBody Vehicle vehicle);
    @PutMapping("/vehicle/bind")
    JsonResult binding(@RequestBody VehicleBinding vehicleBinding);
}
