package edu.aitu.oop3.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rental {
    public int id;
    public int carId;
    public int customerId;
    public LocalDate startDate;
    public LocalDate endDate;
    public LocalDate returnDate;
    public BigDecimal totalCost;
    public String status;

    public Rental(int id, int carId, int customerId,
                  LocalDate startDate, LocalDate endDate,
                  LocalDate returnDate, BigDecimal totalCost,
                  String status) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.status = status;
    }
}