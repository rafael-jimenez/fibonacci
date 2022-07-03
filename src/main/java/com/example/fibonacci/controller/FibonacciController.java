package com.example.fibonacci.controller;

import com.example.fibonacci.services.FibonacciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private  final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/getFibonnaci")
    public ResponseEntity<Long> fibonacci(@RequestParam Long number){
        Long fibonacciNumber = fibonacciService.getFibonnaciNumber(number);

        return ResponseEntity.ok(fibonacciNumber);

    }
}
