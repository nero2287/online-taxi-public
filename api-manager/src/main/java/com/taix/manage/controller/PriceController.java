package com.taix.manage.controller;

import com.taix.manage.service.PriceService;
import com.taxi.common.price.bean.PriceRole;
import com.taxi.common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/add")
    public JsonResult addPriceRole(@RequestBody PriceRole priceRole){
        return priceService.addPriceRole(priceRole);
    }

    @GetMapping("/list")
    public JsonResult getPriceRole(){
        return priceService.getPriceRoleList();
    }

    @PutMapping("/update")
    public JsonResult updatePriceRole(@RequestBody PriceRole priceRole){
        return priceService.updatePriceRole(priceRole);
    }

    @DeleteMapping("/delete")
    public JsonResult deletePriceRole(){
        return null;
    }
}
