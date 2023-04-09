package com.taxi.passenger.service;

import com.taxi.common.bean.Coordinates;
import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-price")
public interface PriceService {

    @PostMapping("/predict_price")
    JsonResult predictPrice(@RequestBody Coordinates coordinates);
}
