package edu.aitu.oop3.model;

public class Customer {
    public int id;
    public String firstName;
    public String lastName;
    public int driverAge;

    public Customer(int id, String firstName, String lastName, int driverAge) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverAge = driverAge;
    }
}