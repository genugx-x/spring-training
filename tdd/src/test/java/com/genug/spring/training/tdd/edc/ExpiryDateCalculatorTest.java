package com.genug.spring.training.tdd.edc;

import com.genug.spring.training.tdd.password.PayData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    void assertExpiryDate(LocalDate expected, PayData payData) {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        assertEquals(expected, calculator.calculateExpiryDate(payData));
    }

    @Test
    @DisplayName("1-1. 만원 납부 시 한달 뒤가 만료일")
    void test_1() {
        assertExpiryDate(LocalDate.of(2022, 4, 1), PayData.builder()
                .billingDate(LocalDate.of(2022, 3, 1))
                .payAmount(10000)
                .build());
        assertExpiryDate(LocalDate.of(2022, 5, 15), PayData.builder()
                .billingDate(LocalDate.of(2022, 4, 15))
                .payAmount(10000)
                .build());
        assertExpiryDate(LocalDate.of(2022, 5, 15), PayData.builder()
                .billingDate(LocalDate.of(2022, 4, 15))
                .payAmount(10000)
                .build());
    }

    @Test
    @DisplayName("1-2. 만원 납부 시 한달 뒤가 만료일 (해가 다른 경우)")
    void test_2() {
        LocalDate billingDate = LocalDate.of(2022, 12, 31);
        assertExpiryDate(LocalDate.of(2023, 1, 31), PayData.builder()
                .billingDate(LocalDate.of(2022, 12, 31))
                .payAmount(10000)
                .build());
    }

    @Test
    @DisplayName("2-1. 납부날과 만료일의 날짜가 다른 경우 (납부일 > 만료일)")
    void test_3() {
        assertExpiryDate(LocalDate.of(2022, 2, 28), PayData.builder()
                .billingDate(LocalDate.of(2022, 1, 31))
                .payAmount(10000)
                .build());
        assertExpiryDate(LocalDate.of(2020, 2, 29), PayData.builder()
                .billingDate(LocalDate.of(2020, 1, 31))
                .payAmount(10000)
                .build());
        assertExpiryDate(LocalDate.of(2022, 9, 30), PayData.builder()
                .billingDate(LocalDate.of(2022, 8, 31))
                .payAmount(10000)
                .build());
    }

    @Test
    @DisplayName("2-2. 납부날과 만료일의 날짜가 다른 경우 (납부일 < 만료일)")
    void test_4() {
        int payAmount = 10000;
//        assertExpiryDate(LocalDate.of(2022, 3, 31), LocalDate.of(2022, 2, 28), payAmount);
//        assertExpiryDate(LocalDate.of(2022, 12, 31), LocalDate.of(2022, 11, 30), payAmount);
    }

    @Test
    @DisplayName("3. 첫 납부일과 만료일 일자가 다를때 만원 납부")
    void test_5() {
        int payAmount = 10000;
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 1, 31))
                .billingDate(LocalDate.of(2022, 2, 28))
                .payAmount(10000)
                .build();
        assertExpiryDate(LocalDate.of(2022, 3, 31), payData);

        assertExpiryDate(LocalDate.of(2022, 3, 30), PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 1, 30))
                .billingDate(LocalDate.of(2022, 2, 28))
                .payAmount(10000)
                .build());
    }
}
