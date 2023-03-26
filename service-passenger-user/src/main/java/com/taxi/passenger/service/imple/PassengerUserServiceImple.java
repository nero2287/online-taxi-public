package com.taxi.passenger.service.imple;

import com.taxi.common.api_enum.AccountStatus;
import com.taxi.common.api_enum.GenderEnum;
import com.taxi.passenger.bean.PassengerUser;
import com.taxi.passenger.mapper.PassengerUserMapper;
import com.taxi.passenger.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerUserServiceImple implements PassengerUserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

    @Override
    public String registerAndLogin(String passengerPhone) {
        Map<String,Object> map = new HashMap<>();
        map.put("passengerPhone",passengerPhone);
        //查询数据库
        List<PassengerUser> userList = passengerUserMapper.selectByMap(map);
        if(userList.size()==0){
            //注册
            PassengerUser passengerUser = new PassengerUser();
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setPassengerName("用户");
            passengerUser.setPassengerGender(GenderEnum.WALMART_BAG.getKey());
            passengerUser.setState(AccountStatus.ACTIVATED.getKey());
            passengerUser.setCreateTime(LocalDateTime.now());

            passengerUserMapper.insert(passengerUser);
        }

        //登录
        return null;
    }
}
