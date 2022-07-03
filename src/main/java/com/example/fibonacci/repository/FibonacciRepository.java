package com.example.fibonacci.repository;

import com.example.fibonacci.entity.FibonacciNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FibonacciRepository extends JpaRepository<FibonacciNumberEntity, BigInteger> {
}
