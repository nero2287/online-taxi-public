package com.taxi.price.service;

import com.taxi.common.bean.Coordinates;
import com.taxi.common.price.bean.PriceRole;

import java.util.List;

public interface PriceService {
    double predictPrice(Coordinates coordinates);

    boolean addPriceRole(PriceRole priceRole);

    boolean updatePriceRole(PriceRole priceRole);

    List<PriceRole> getList();
}
