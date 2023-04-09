package com.taix.driver.service;

import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.DriverStates;
import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("driver-user")
public interface DriverService {

    @PutMapping("/driver/user")
    JsonResult editUser(@RequestBody Driver driver);
    @RequestMapping(method = RequestMethod.GET,value = "/driver/check_user")
    JsonResult checkUser(@RequestParam String driverPhone);
    @PostMapping("/driver/work-status")
    JsonResult editWorkStatus(@RequestBody DriverStates driverStates);
}
