package com.taxi.price.remote;

import com.taxi.common.bean.Coordinates;
import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-map")
public interface MapService {
    @PostMapping("/getRoutes")
    JsonResult getRoutes(@RequestBody Coordinates coordinates);
}
