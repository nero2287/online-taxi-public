package com.taxi.price.controller;

import com.taxi.common.bean.Coordinates;
import com.taxi.common.price.bean.PriceRole;
import com.taxi.common.util.JsonResult;
import com.taxi.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/predict_price")
    public JsonResult predictPrice(@RequestBody Coordinates coordinates){
        return JsonResult.success().put("price",priceService.predictPrice(coordinates));
    }

    @PostMapping("/addPriceRole")
    public JsonResult addPriceRole(@RequestBody PriceRole priceRole){
        if(priceService.addPriceRole(priceRole)){
            return JsonResult.success().setData("ok");
        }else{
            return JsonResult.fail().setData("计价规则已存在");
        }
    }

    @GetMapping("/getList")
    public JsonResult getList(){
        return JsonResult.success().put("priceRoleList",priceService.getList());
    }

    @PutMapping("/updatePriceRole")
    public JsonResult updatePriceRole(@RequestBody PriceRole priceRole){
        if(priceService.updatePriceRole(priceRole)){
            return JsonResult.success().setData("ok");
        }else{
            return JsonResult.success().setData("计价规则不存在");
        }
    }
}
