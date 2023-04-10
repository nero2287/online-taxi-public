package com.taxi.passenger.service;

import com.taxi.common.bean.DoubleToken;
import com.taxi.passenger.bean.PassengerUser;

public interface PassengerUserService {

    /**
     * 注册和登录
     * @return
     */
    DoubleToken registerAndLogin(String passengerPhone);

    PassengerUser getUserInfo(String passengerPhone);
}
