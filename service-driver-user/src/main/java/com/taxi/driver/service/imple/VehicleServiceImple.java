package com.taxi.driver.service.imple;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.taxi.common.driver.bean.Vehicle;
import com.taxi.common.driver.bean.VehicleBinding;
import com.taxi.common.driver.driverEnum.BindingStates;
import com.taxi.driver.mapper.BindMapper;
import com.taxi.driver.mapper.VehicleMapper;
import com.taxi.driver.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleServiceImple implements VehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private BindMapper bindMapper;


    @Override
    public boolean bind(VehicleBinding vehicleBinding) {
        int state = 0;
        Map<String,Object> map = new HashMap<>();
        map.put("driver_id",vehicleBinding.getDriverId());
        map.put("vehicle_id",vehicleBinding.getVehicleId());
        List<VehicleBinding> vehicleBindingList = bindMapper.selectByMap(map);
        if(vehicleBindingList.size()>0){
            vehicleBinding.setBindingTime(LocalDateTime.now());
            UpdateWrapper<VehicleBinding> updateWrapper = new UpdateWrapper<VehicleBinding>();
            updateWrapper.eq("driver_id",vehicleBinding.getDriverId());
            updateWrapper.eq("vehicle_id",vehicleBinding.getVehicleId());
            //如果存在
            state = bindMapper.update(vehicleBinding,updateWrapper);
        }else{
            //如果不存在

            state = bindMapper.insert(vehicleBinding);
        }
        return state!=0;
    }

    @Override
    public boolean vehicle(Vehicle vehicle) {
        int a = 0;
        if(vehicle.getId()==0){
            //新增
            vehicle.setCreateTime(LocalDateTime.now());
            a = vehicleMapper.insert(vehicle);
        }else{
            //修改
            vehicle.setUpdateTime(LocalDateTime.now());
            a = vehicleMapper.updateById(vehicle);
        }
        return a!=0;
    }
}
