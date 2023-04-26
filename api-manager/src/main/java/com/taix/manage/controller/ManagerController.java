package com.taix.manage.controller;

import com.taix.manage.service.DriverUserService;
import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.Vehicle;
import com.taxi.common.driver.bean.VehicleBinding;
import com.taxi.common.driver.driverEnum.BindingStates;
import com.taxi.common.util.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ManagerController {

    @Autowired
    private DriverUserService driverUserService;

    @PostMapping("/driver-user")
    public JsonResult addUser(@RequestBody Driver driver){
        return driverUserService.addUser(driver);
    }

    @PutMapping("/driver-user")
    public JsonResult updateUser(@RequestBody Driver driver){
        return driverUserService.updateUser(driver);
    }

    @PostMapping("/vehicle")
    public JsonResult addVehicle(@RequestBody Vehicle vehicle){
        if(StringUtils.isBlank(vehicle.getVehicleNo())){
            return JsonResult.fail().setData("车牌号不能为空");
        }
        return driverUserService.vehicle(vehicle);
    }

    @PutMapping("/vehicle")
    public JsonResult editVehicle(@RequestBody Vehicle vehicle){
        return driverUserService.vehicle(vehicle);
    }

    @PutMapping("/bind")
    public JsonResult binding(@RequestBody VehicleBinding vehicleBinding){
        vehicleBinding.setBindingState(BindingStates.BIND.getCode());
        return driverUserService.binding(vehicleBinding);
    }

    @PutMapping("/unbind")
    public JsonResult unbinding(@RequestBody VehicleBinding vehicleBinding){
        vehicleBinding.setBindingState(BindingStates.UNBIND.getCode());
        return driverUserService.binding(vehicleBinding);
    }
}
