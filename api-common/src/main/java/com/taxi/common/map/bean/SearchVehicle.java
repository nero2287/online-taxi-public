package com.taxi.common.map.bean;

import lombok.Data;

import java.util.List;

@Data
public class SearchVehicle {
    private int status;
    private String message;
    private int total;
    private int size;
    private List<Entity> entities;
}
