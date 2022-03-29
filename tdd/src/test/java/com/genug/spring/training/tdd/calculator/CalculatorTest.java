package com.genug.spring.training.tdd.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void plus() {
        assertEquals(3, Calculator.plus(1, 2));
        assertEquals(5, Calculator.plus(4, 1));
    }

}
