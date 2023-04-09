package com.taix.driver.controller;

import com.taix.driver.service.DriverService;
import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.DriverStates;
import com.taxi.common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PutMapping("/user")
    public JsonResult editUser(@RequestBody Driver driver){
        return driverService.editUser(driver);
    }

    @PutMapping("/work-status")
    private JsonResult editWorkStatus(@RequestBody DriverStates driverStates){
        return driverService.editWorkStatus(driverStates);
    }

}

