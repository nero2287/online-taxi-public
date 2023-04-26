package com.taxi.price.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxi.common.price.bean.PriceRole;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceMapper extends BaseMapper<PriceRole> {
}
