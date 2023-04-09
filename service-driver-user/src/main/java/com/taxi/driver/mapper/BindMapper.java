package com.taxi.driver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxi.common.driver.bean.VehicleBinding;
import org.springframework.stereotype.Repository;

@Repository
public interface BindMapper extends BaseMapper<VehicleBinding> {
}
