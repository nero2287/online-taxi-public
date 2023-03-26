package com.taxi.passenger.service;

import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("passenger-user")
public interface PassengerUserService {

    @GetMapping("/user")
    JsonResult checkUser(String passengerPhone);
}
