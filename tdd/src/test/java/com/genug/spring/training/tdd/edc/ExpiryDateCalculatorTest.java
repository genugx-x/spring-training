package com.genug.spring.training.tdd.edc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ExpiryDateCalculatorTest {

    @Test
    @DisplayName("1. 만원 납부 시 한달 뒤가 만료일")
    void test_1() {
        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10000;

        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate expiryDate = calculator.calculateExpiryDate(billingDate, payAmount);
        assertEquals(LocalDate.of(2019, 4, 1), expiryDate);
    }
}
