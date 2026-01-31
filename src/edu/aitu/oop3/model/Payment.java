package edu.aitu.oop3.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Payment {
    private int id;
    private int rentalId;
    private BigDecimal amount;
    private OffsetDateTime paidAt;

    public Payment(int id, int rentalId, BigDecimal amount, OffsetDateTime paidAt) {
        this.id = id;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paidAt = paidAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OffsetDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(OffsetDateTime paidAt) {
        this.paidAt = paidAt;
    }
}