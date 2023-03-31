package com.taix.map.controller;

import com.taix.map.bean.Coordinates;
import com.taix.map.bean.MapRoutes;
import com.taix.map.service.MapService;
import com.taxi.common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    @Autowired
    private MapService mapService;

    @PostMapping("/getRoutes")
    public JsonResult getRoutes(@RequestBody Coordinates coordinates){
        return JsonResult.success(mapService.getRoutes(coordinates));
    }
}
