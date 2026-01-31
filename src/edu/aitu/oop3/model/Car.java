package edu.aitu.oop3.model;

import java.math.BigDecimal;

public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private BigDecimal dailyRate;
    private boolean available;

    public Car(int id, String make, String model, int year,
               BigDecimal dailyRate, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return id + ": " + make + " " + model +
                " (" + year + ") | " + dailyRate + " per day";
    }
}