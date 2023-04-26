package com.taix.manage.service;

import com.taxi.common.price.bean.PriceRole;
import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-price")
public interface PriceService {

    @PostMapping("/addPriceRole")
    JsonResult addPriceRole(@RequestBody PriceRole priceRole);
    @PutMapping("/updatePriceRole")
    JsonResult updatePriceRole(@RequestBody PriceRole priceRole);
    @GetMapping("/getList")
    JsonResult getPriceRoleList();

}
