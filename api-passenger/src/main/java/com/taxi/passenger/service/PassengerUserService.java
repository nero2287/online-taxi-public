package com.taxi.passenger.service;

import com.taxi.common.util.JsonResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("passenger-user")
public interface PassengerUserService {

    @GetMapping("/user")
    JsonResult checkUser(@RequestParam("passengerPhone") String passengerPhone);

    @GetMapping("/user/{passengerPhone}")
    JsonResult getUser(@PathVariable String passengerPhone);
}
