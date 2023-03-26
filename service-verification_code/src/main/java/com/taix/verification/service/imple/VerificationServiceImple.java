package com.taix.verification.service.imple;

import com.taix.verification.service.VerificationService;
import org.springframework.stereotype.Service;

import static java.lang.Math.*;


@Service
public class VerificationServiceImple implements VerificationService {
    @Override
    public int RandomNum(int size) {
        double random = (random()*9+1)* (Math.pow(10,size-1));
        return (int)random;
    }
}
