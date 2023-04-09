package com.taix.driver.service.imple;

import com.taix.driver.service.UserService;
import com.taxi.common.api_enum.TokenIdentify;
import com.taxi.common.bean.DoubleToken;
import com.taxi.common.bean.TokenBean;
import com.taxi.common.util.TokenUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

    @Override
    public DoubleToken login(String driverPhone) {
        TokenBean tokenBean = new TokenBean();
        tokenBean.setIdentify(TokenIdentify.DRIVER.getCode());
        tokenBean.setPhone(driverPhone);
        return TokenUtil.createDoubleToken(tokenBean);
    }
}
