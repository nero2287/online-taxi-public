package com.taxi.driver.controller;

import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.DriverStates;
import com.taxi.driver.service.DriverService;
import com.taxi.common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverUserController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/user")
    public JsonResult addDriver(@RequestBody Driver driver){
        driver.setFlag(1);
        if(driverService.putDriver(driver)){
            return JsonResult.success();
        }else{
            return JsonResult.error("驾驶员信息重复");
        }
    }

    @PutMapping("/user")
    public JsonResult updateDriver(@RequestBody Driver driver){
        driver.setFlag(2);
        if(driverService.putDriver(driver)){
            return JsonResult.success();
        }else{
            return JsonResult.error("修改失败");
        }
    }

    @GetMapping("/check_user")
    public JsonResult checkUser(String driverPhone){
        return JsonResult.success(driverService.checkUser(driverPhone)!=null);
    }

    @PostMapping("/work-status")
    public JsonResult workStatus(@RequestBody DriverStates driverStates){
        return JsonResult.success(driverService.editStatus(driverStates));
    }
}
