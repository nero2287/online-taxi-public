package com.taxi.passenger.service;

import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("verification")
public interface VerificationService {
    @GetMapping("/verification_code")
    JsonResult getVerification_code();
}
