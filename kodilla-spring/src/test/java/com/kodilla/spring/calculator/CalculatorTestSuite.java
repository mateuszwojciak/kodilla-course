package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testAddition() {
        //Given
        //When
        calculator.add(5, 5);

        //Then
    }

    @Test
    void testSubtraction() {
        //Given
        //When
        calculator.sub(100, 25);

        //Then
    }

    @Test
    void testMultiplication() {
        //Given
        //When
        calculator.mul(15, 4);

        //Then
    }
    @Test
    void testDivision() {
        //Given
        //When
        calculator.div(21, 7);

        //Then
    }
}
