package com.taxi.driver.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.taxi.common.driver.bean.Driver;
import com.taxi.common.driver.bean.DriverStates;
import com.taxi.driver.mapper.DriverMapper;
import com.taxi.driver.mapper.DriverStatusMapper;
import com.taxi.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DriverServiceImple implements DriverService {

    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private DriverStatusMapper driverStatusMapper;
    @Override
    public boolean putDriver(Driver driver) {
        int flag = driver.getFlag();
        if(driver.getFlag()==1){
            QueryWrapper<Driver> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("driver_phone");
            if(driverMapper.selectOne(queryWrapper)!=null){
                return false;
            }else{
                driver.setCreateTime(LocalDateTime.now());
                driverMapper.insert(driver);
            }
        }else if(flag == 2){
            driver.setUpdateTime(LocalDateTime.now());
            UpdateWrapper<Driver> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("driver_phone",driver.getDriverPhone());
            int update = driverMapper.update(driver, updateWrapper);
            if(update==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Driver checkUser(String driverPhone) {
        QueryWrapper<Driver> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true,"driver_phone",driverPhone);
        return driverMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean editStatus(DriverStates driverStates) {
        QueryWrapper<DriverStates> queryWrapper = new QueryWrapper<DriverStates>();
        queryWrapper.eq(true,"driver_id",driverStates.getDriverId());
        if(driverStatusMapper.selectList(queryWrapper).size()!=0){
            driverStates.setUpdateTime(LocalDateTime.now());
            UpdateWrapper<DriverStates> updateWrapper = new UpdateWrapper<DriverStates>();
            updateWrapper.eq(true,"driver_id",driverStates.getDriverId());
            return driverStatusMapper.update(driverStates,updateWrapper)!=0;
        }else{
            driverStates.setCreateTime(LocalDateTime.now());
            return driverStatusMapper.insert(driverStates)!=0;
        }
    }
}
