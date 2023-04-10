package com.taxi.price.controller;

import com.taxi.common.bean.Coordinates;
import com.taxi.common.util.JsonResult;
import com.taxi.price.remote.MapService;
import com.taxi.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/predict_price")
    public JsonResult predictPrice(@RequestBody Coordinates coordinates){
        return JsonResult.success().put("price",priceService.predictPrice(coordinates));
    }

}
