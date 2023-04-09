package com.taxi.driver.controller;

import com.taxi.common.driver.bean.Vehicle;
import com.taxi.common.driver.bean.VehicleBinding;
import com.taxi.common.util.JsonResult;
import com.taxi.driver.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/bind")
    public JsonResult bindingVehicle(@RequestBody VehicleBinding vehicleBinding){
        if(vehicleService.bind(vehicleBinding))
            return JsonResult.success();
        else
            return JsonResult.fail("绑定失败，请联系管理员");
    }

    @PostMapping("/info")
    public JsonResult editVehicle(@RequestBody Vehicle vehicle){
        if(vehicleService.vehicle(vehicle))
            return JsonResult.success();
        else
            return JsonResult.fail("车辆信息编辑失败，请联系管理员");
    }
}
