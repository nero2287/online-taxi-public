package com.taxi.price.service.imple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxi.common.util.BigDecimalUtil;
import com.taxi.price.bean.PriceRole;
import com.taxi.price.mapper.PriceMapper;
import com.taxi.price.remote.MapService;
import com.taxi.price.service.PriceService;
import com.taxi.common.bean.Coordinates;
import com.taxi.common.bean.MapRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriceServiceImple implements PriceService {
    @Autowired
    private MapService mapService;
    @Autowired
    private PriceMapper priceMapper;

    @Override
    public double predictPrice(Coordinates coordinates) {
        //获得地图路径
        MapRoutes mapRoutes = new ObjectMapper().convertValue(mapService.getRoutes(coordinates).getData(),MapRoutes.class);
        //获得计价规则
        Map<String,Object> map = new HashMap<>();
        map.put("city_code",coordinates.getCity_code());
        List<PriceRole> priceRoleList = priceMapper.selectByMap(map);
        PriceRole priceRole = priceRoleList.get(0);
        //计算价格
        double price = predict(mapRoutes,priceRole);
        return price;
    }

    private double predict(MapRoutes mapRoutes,PriceRole priceRole){
        int distance = mapRoutes.getDistance();
        int duration = mapRoutes.getDuration();
        double price = 0;
        double time_price=0;
        //距离：公里
        double distance_km = BigDecimalUtil.divide(distance,1000);
        double duration_m = BigDecimalUtil.divide(duration,60);
        //公里计程
        if (distance_km>priceRole.getStartMile()) {
            //公里*单价
            price = BigDecimalUtil.add(price, BigDecimalUtil.multiplication(distance_km, priceRole.getUnitPricePerMile()));
        } else {
            //起步价
            price = BigDecimalUtil.add(price,priceRole.getStartFare());
        }
        //时长计程
        if(duration_m>priceRole.getStartMinute()){
            time_price = BigDecimalUtil.multiplication(duration_m,priceRole.getUnitPricePerMinute());
        }

        //时长价+公里价
        return BigDecimalUtil.add(price,time_price);
    }
}
