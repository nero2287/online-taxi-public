package com.taix.map.service;

import com.taix.map.bean.Coordinates;
import com.taix.map.bean.MapRoutes;

public interface MapService {
    MapRoutes getRoutes(Coordinates coordinates);
}
