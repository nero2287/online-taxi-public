package com.taix.map.service.imple;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taix.map.bean.Coordinates;
import com.taix.map.bean.MapRoutes;
import com.taix.map.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.nio.cs.ext.MacArabic;

import java.math.BigDecimal;

@Service
public class MapServiceImple implements MapService {

    @Value("${map.ak}")
    public String ak;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public MapRoutes getRoutes(Coordinates coordinates) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(driving(coordinates),String.class);
        String json = responseEntity.getBody();
        MapRoutes mapRoutes = null;
        JSONObject jsonObject = JSONObject.parseObject(json);
        int status = jsonObject.getInteger("status");
        if(status==0){
            mapRoutes = new MapRoutes();
            String result = jsonObject.getString("result");
            JSONObject jsonResult = JSONObject.parseObject(result);
            String routes = jsonResult.getString("routes");
            JSONArray jsonArray = JSONObject.parseArray(routes);
            mapRoutes.setDistance(jsonArray.getJSONObject(0).getIntValue("distance"));
            mapRoutes.setDuration(jsonArray.getJSONObject(0).getIntValue("duration"));
        }else{
            return null;
        }
        return mapRoutes;
    }

    private String driving(Coordinates coordinates){
        String origin = coordinates.getDepLatitude()+","+coordinates.getDepLongitude();
        String destination = coordinates.getDestLatitude()+","+coordinates.getDestLongitude();
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.map.baidu.com/directionlite/v1/driving");
        sb.append("?");
        sb.append("origin=");
        sb.append(origin);
        sb.append("&");
        sb.append("destination=");
        sb.append(destination);
        sb.append("&");
        sb.append("ak=");
        sb.append(ak);
        return sb.toString();
    }
}
