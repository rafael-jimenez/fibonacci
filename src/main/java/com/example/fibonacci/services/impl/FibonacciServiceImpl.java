package com.example.fibonacci.services.impl;

import com.example.fibonacci.entity.FibonacciNumberEntity;
import com.example.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.services.FibonacciService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    private  final FibonacciRepository fibonacciRepository;

    public FibonacciServiceImpl(FibonacciRepository fibonacciRepository) {
        this.fibonacciRepository = fibonacciRepository;
    }

    @Override
    public BigInteger getFibonnaciNumber(BigInteger number) {
        BigInteger response;
        if(number.equals(BigInteger.ZERO) ){
            response = BigInteger.ZERO;
        } else if (number.equals(BigInteger.ONE)) {
            response = BigInteger.ONE;
        } else {
            var fibonnaciNumber =fibonacciRepository.findById(number);
            if (fibonnaciNumber.isPresent()){
                response = new BigInteger(fibonnaciNumber.get().getFibonacciNumber());
            } else {
                var fibonnaciSubstracOne = getFibonnaciNumber(number.subtract(BigInteger.ONE));
                var fibonnaciSubstracTwo = getFibonnaciNumber(number.subtract(BigInteger.TWO));

                response = fibonnaciSubstracOne.add(fibonnaciSubstracTwo);
                FibonacciNumberEntity saveData = new FibonacciNumberEntity();
                saveData.setId(number);
                saveData.setFibonacciNumber(response.toString());
                fibonacciRepository.save(saveData);
            }
        }
        return response;
    }
}
