package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testAddition() {
        //Given
        //When
        double result = calculator.add(5, 5);

        //Then
        Assertions.assertEquals(10, result);
    }

    @Test
    void testSubtraction() {
        //Given
        //When
        double result = calculator.sub(100, 25);

        //Then
        Assertions.assertEquals(75, result);
    }

    @Test
    void testMultiplication() {
        //Given
        //When
        double result = calculator.mul(15, 4);

        //Then
        Assertions.assertEquals(60, result);
    }
    @Test
    void testDivision() {
        //Given
        //When
        double result = calculator.div(21, 7);

        //Then
        Assertions.assertEquals(3, result);
    }
}
