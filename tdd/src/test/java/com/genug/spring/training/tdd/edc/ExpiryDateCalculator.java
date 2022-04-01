package com.genug.spring.training.tdd.edc;

import com.genug.spring.training.tdd.password.PayData;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(1);
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
            /*
            if (payData.getFirstBillingDate().equals(LocalDate.of(2022, 1, 31))) {
                return LocalDate.of(2022, 3, 31);
            }
             */
        }
        return payData.getBillingDate().plusMonths(1);
    }

}