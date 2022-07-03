package com.example.fibonacci.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity(name = "Fibonacci_value")
@Getter
@Setter
@NoArgsConstructor
public class FibonacciNumberEntity {
    @Id
    private BigInteger id;

    private String fibonacciNumber;
}
