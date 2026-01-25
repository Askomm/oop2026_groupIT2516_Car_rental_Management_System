package edu.aitu.oop3.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Payment {
    public int id;
    public int rentalId;
    public BigDecimal amount;
    public OffsetDateTime paidAt;

    public Payment(int id, int rentalId, BigDecimal amount, OffsetDateTime paidAt) {
        this.id = id;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paidAt = paidAt;
    }
}