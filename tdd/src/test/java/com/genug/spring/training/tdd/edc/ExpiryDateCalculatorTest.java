package com.genug.spring.training.tdd.edc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ExpiryDateCalculatorTest {

    void assertExpiryDate(LocalDate expected, LocalDate billingDate, int payAmount) {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        assertEquals(expected, calculator.calculateExpiryDate(billingDate, payAmount));
    }

    @Test
    @DisplayName("1-1. 만원 납부 시 한달 뒤가 만료일")
    void test_1() {
        int payAmount = 10000;
        LocalDate billingDate = LocalDate.of(2022, 3, 1);
        assertExpiryDate(LocalDate.of(2022, 4, 1), billingDate, payAmount);
        billingDate = LocalDate.of(2022, 4, 15);
        assertExpiryDate(LocalDate.of(2022, 5, 15), billingDate, payAmount);
        billingDate = LocalDate.of(2022, 4, 15);
        assertExpiryDate(LocalDate.of(2022, 5, 15), billingDate, payAmount);
    }

    @Test
    @DisplayName("1-2. 만원 납부 시 한달 뒤가 만료일 (해가 다른 경우)")
    void test_2() {
        int payAmount = 10000;
        LocalDate billingDate = LocalDate.of(2022, 12, 31);
        assertExpiryDate(LocalDate.of(2023, 1, 31), billingDate, payAmount);
    }

    @Test
    @DisplayName("2-1. 납부날과 만료일의 날짜가 다른 경우 (납부일 > 만료일)")
    void test_3() {
        int payAmount = 10000;
        LocalDate billingDate = LocalDate.of(2022, 1, 31);
        assertExpiryDate(LocalDate.of(2022, 2, 28), billingDate, payAmount);

        billingDate = LocalDate.of(2020, 1, 31);
        assertExpiryDate(LocalDate.of(2020, 2, 29), billingDate, payAmount);

        billingDate = LocalDate.of(2022, 8, 31);
        assertExpiryDate(LocalDate.of(2022, 9, 30), billingDate, payAmount);
    }

    @Test
    @DisplayName("2-2. 납부날과 만료일의 날짜가 다른 경우 (납부일 < 만료일)")
    void test_4() {
        int payAmount = 10000;
        assertExpiryDate(LocalDate.of(2022, 3, 31), LocalDate.of(2022, 2, 28), payAmount);
        assertExpiryDate(LocalDate.of(2022, 12, 31), LocalDate.of(2022, 11, 30), payAmount);
    }
}
