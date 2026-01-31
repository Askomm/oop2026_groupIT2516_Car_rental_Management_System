package edu.aitu.oop3.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int driverAge;

    public Customer(int id, String firstName, String lastName, int driverAge) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverAge = driverAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }
}