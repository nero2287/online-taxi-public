package com.taxi.driver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxi.common.driver.bean.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMapper extends BaseMapper<Vehicle> {
}
