package com.taix.driver.service;

import com.taxi.common.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("verification")
public interface VerificationService {

    @GetMapping("/verification_code")
    JsonResult getVerification();
}
