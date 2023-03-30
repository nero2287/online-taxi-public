package com.taxi.passenger.service;

import com.taxi.common.bean.DoubleToken;

public interface PassengerUserService {

    /**
     * 注册和登录
     * @return
     */
    DoubleToken registerAndLogin(String passengerPhone);

}
