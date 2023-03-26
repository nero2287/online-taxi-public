package com.taix.verification.service;

import org.springframework.stereotype.Service;

public interface VerificationService {

    int RandomNum(int size);

    boolean checkCode();
}
