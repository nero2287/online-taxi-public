package com.taxi.passenger.controller;

import com.taxi.common.bean.DoubleToken;
import com.taxi.common.util.JsonResult;
import com.taxi.passenger.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerUserController {

    @Autowired
    private PassengerUserService passengerUserService;

    /**
     * 登录或者注册
     * @param passengerPhone
     * @return
     */
    @GetMapping("/user")
    public JsonResult registerAndLogin(String passengerPhone){
        return JsonResult.success(passengerUserService.registerAndLogin(passengerPhone));
    }

    @GetMapping("/user/{passengerPhone}")
    public JsonResult getUser(@PathVariable String passengerPhone){
        return JsonResult.success(passengerUserService.getUserInfo(passengerPhone));
    }

}
