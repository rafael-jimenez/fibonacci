package com.example.fibonacci.services;

import com.example.fibonacci.entity.FibonacciNumberEntity;
import com.example.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.services.impl.FibonacciServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciServiceImplTest {

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    FibonacciRepository repository;

    @InjectMocks
    FibonacciServiceImpl fibonacciService;

    @Test
    public void initialCases(){
        var case0 = fibonacciService.getFibonnaciNumber(BigInteger.ZERO);
        var case1 = fibonacciService.getFibonnaciNumber(BigInteger.ONE);

        assertEquals(case0, BigInteger.ZERO);
        assertEquals(case1,BigInteger.ONE);

    }

    @Test
    public void noDataOnDataBase(){

        Mockito.when(repository.findById(Mockito.any(BigInteger.class)))
                        .thenReturn(Optional.empty());
        var value =fibonacciService.getFibonnaciNumber(BigInteger.valueOf(3L));
        assertEquals(value,BigInteger.TWO);

    }

    @Test
    public void DataOnDataBase(){

        Mockito.when(repository.findById(BigInteger.valueOf(4L)))
                .thenReturn(Optional.empty());


        FibonacciNumberEntity numberEntityTwo = new FibonacciNumberEntity();
        numberEntityTwo.setId(BigInteger.valueOf(2L));
        numberEntityTwo.setFibonacciNumber("1");

        FibonacciNumberEntity numberEntityThree = new FibonacciNumberEntity();
        numberEntityThree.setId(BigInteger.valueOf(3L));
        numberEntityThree.setFibonacciNumber("2");

        FibonacciNumberEntity numberEntityFour = new FibonacciNumberEntity();
        numberEntityFour.setId(BigInteger.valueOf(4L));
        numberEntityFour.setFibonacciNumber("3");


        Mockito.when(repository.findById(BigInteger.valueOf(2L)))
                .thenReturn(Optional.of(numberEntityTwo));

        Mockito.when(repository.findById(BigInteger.valueOf(3L)))
                .thenReturn(Optional.of(numberEntityThree));

        Mockito.when(repository.save(Mockito.any(FibonacciNumberEntity.class)))
                .thenReturn(numberEntityFour);


        var value =fibonacciService.getFibonnaciNumber(BigInteger.valueOf(4L));
        assertEquals(value,BigInteger.valueOf(3L));

    }
}
