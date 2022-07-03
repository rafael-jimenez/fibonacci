package com.example.fibonacci.controller;

import com.example.fibonacci.services.FibonacciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FibonacciController {

    private  final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/getFibonnaci")
    public ResponseEntity<BigInteger> fibonacci(@RequestParam Long number){
        if(true){

        }
        BigInteger fibonacciNumber = fibonacciService.getFibonnaciNumber(BigInteger.valueOf(number));

        return ResponseEntity.ok(fibonacciNumber);

    }
}
