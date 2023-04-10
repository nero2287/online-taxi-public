package com.taix.map.service;


import com.taxi.common.bean.Coordinates;
import com.taxi.common.bean.MapRoutes;

public interface MapService {
    MapRoutes getRoutes(Coordinates coordinates);
}
