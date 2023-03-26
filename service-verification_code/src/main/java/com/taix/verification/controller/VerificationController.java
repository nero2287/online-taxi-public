package com.taix.verification.controller;

import com.taix.verification.service.VerificationService;
import com.taxi.common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    @GetMapping("/verification_code")
    public JsonResult verification_code(){
        return JsonResult.success().setData(verificationService.RandomNum(6));
    }

    @PostMapping("/check_verification_code")
    public JsonResult checkVerificationCode(String passengerPhone,String verification_code){
        return null;
    }
}
