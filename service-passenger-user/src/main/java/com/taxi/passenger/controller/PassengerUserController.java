package com.taxi.passenger.controller;

import com.taxi.common.util.JsonResult;
import com.taxi.passenger.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerUserController {

    @Autowired
    private PassengerUserService passengerUserService;

    @GetMapping("/user")
    public JsonResult getUser(String passengerPhone){
        passengerUserService.registerAndLogin(passengerPhone);
        return JsonResult.success();
    }

}
