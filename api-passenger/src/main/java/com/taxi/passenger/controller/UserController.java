package com.taxi.passenger.controller;

import com.taxi.common.bean.TokenBean;
import com.taxi.common.util.JsonResult;
import com.taxi.common.util.TokenUtil;
import com.taxi.passenger.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private PassengerUserService passengerUserService;

    @GetMapping("/user")
    public JsonResult getUser(HttpServletRequest request){
        //获得token
        String accessToken = request.getHeader("Authorization");
        //解析token
        TokenBean tokenBean = TokenUtil.decodeToken(accessToken);

        return passengerUserService.getUser(tokenBean.getPhone());
    }

}
