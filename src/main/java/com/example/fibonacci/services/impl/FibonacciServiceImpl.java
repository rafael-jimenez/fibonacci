package com.example.fibonacci.services.impl;

import com.example.fibonacci.services.FibonacciService;
import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {
    @Override
    public Long getFibonnaciNumber(Long number) {
        Long response;
        if(number == 0L ){
            response = 0L;
        } else if (number == 1L) {
            response = 1L;
        } else {
            response = getFibonnaciNumber(number-1) + getFibonnaciNumber(number-2);
        }
        return response;
    }
}
