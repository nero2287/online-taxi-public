package com.taxi.common.map.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Entity {
    private String ak;
    private long service_id;
    private String entity_name;
    private String entity_desc;
}
