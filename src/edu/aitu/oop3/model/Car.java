package edu.aitu.oop3.model;

import java.math.BigDecimal;

public class Car {
    public int id;
    public String make;
    public String model;
    public int year;
    public BigDecimal dailyRate;
    public boolean isAvailable;

    public Car(int id, String make, String model, int year,
               BigDecimal dailyRate, boolean isAvailable) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return id + ": " + make + " " + model +
                " (" + year + ") | " + dailyRate + " per day";
    }
}