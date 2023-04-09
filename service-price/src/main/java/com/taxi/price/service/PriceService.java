package com.taxi.price.service;

import com.taxi.common.bean.Coordinates;

public interface PriceService {
    double predictPrice(Coordinates coordinates);
}
