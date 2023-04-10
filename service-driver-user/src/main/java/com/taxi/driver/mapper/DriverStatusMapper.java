package com.taxi.driver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxi.common.driver.bean.DriverStates;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverStatusMapper extends BaseMapper<DriverStates> {
}
