package com.taxi.passenger.controller;

import com.taxi.common.util.JsonResult;
import com.taxi.passenger.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiPassengerController {

    @Autowired
    private VerificationService verificationService;

    @GetMapping("/verification_code")
    public JsonResult getVerification_code(String passengerPhone){
        return verificationService.getVerification_code();
    }
}
