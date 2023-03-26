package com.taxi.passenger.controller;

import com.taxi.common.util.JsonResult;
import com.taxi.passenger.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class ApiPassengerController {

    private final String fix = "api-passenger-verification-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private VerificationService verificationService;

    @GetMapping("/verification_code")
    public JsonResult getVerification_code(String passengerPhone){
        //生成redis键值
        String redis_key = fix+passengerPhone;
        //验证码重发键值
        String repeat_key = fix+passengerPhone+"repeat";
        //检查验证码是否重复发送
        String repeat_value= stringRedisTemplate.opsForValue().get(repeat_key);
        if(repeat_value!=null){
            return JsonResult.tip("操作频繁，请稍后再试。");
        }
        String code = verificationService.getVerification_code().getCode()+"";//从服务端获取验证码
        //存入redis并且保存30分钟
        stringRedisTemplate.opsForValue().set(redis_key,code,30, TimeUnit.MINUTES);
        //验证码重发计时
        stringRedisTemplate.opsForValue().set(repeat_key,passengerPhone,1, TimeUnit.MINUTES);
        //通过通讯运营商API发送到用户手机
        return JsonResult.success();
    }

    @PostMapping("/verification_code_check")
    public JsonResult checkVerificationCode(String passengerPhone,String verification_code){
        String redis_key = fix+passengerPhone;
        String redis_code = stringRedisTemplate.opsForValue().get(redis_key);
        if(redis_code.equals(verification_code)){
            //验证码通过
            List<String> redisKeyList = new ArrayList<>();
            redisKeyList.add(fix+passengerPhone);
            redisKeyList.add(fix+passengerPhone+"repeat");
            //删除redis中的验证码
            stringRedisTemplate.delete(redisKeyList);
        }else{
            //验证码错误
            return JsonResult.fail("验证码错误,请使用尾号"+passengerPhone.substring(8,13)+"查看验证码");
        }
        return JsonResult.success();
    }
}
