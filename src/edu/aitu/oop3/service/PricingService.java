package edu.aitu.oop3.service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class PricingService {

    public BigDecimal calculate(BigDecimal dailyRate,
                                LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        if (days <= 0) days = 1;
        return dailyRate.multiply(BigDecimal.valueOf(days));
    }
}
