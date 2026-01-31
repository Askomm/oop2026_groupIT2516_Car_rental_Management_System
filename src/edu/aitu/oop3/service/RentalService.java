package edu.aitu.oop3.service;

import edu.aitu.oop3.repo.*;
import edu.aitu.oop3.model.*;
import edu.aitu.oop3.exceptions.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.math.BigDecimal;

public class RentalService {

    private final CarRepository carRepo = new CarRepository();
    private final CustomerRepository customerRepo = new CustomerRepository();
    private final RentalRepository rentalRepo = new RentalRepository();
    private final PaymentRepository paymentRepo = new PaymentRepository();
    private final PricingService pricing = new PricingService();

    public int createRental(Connection conn, int carId, int customerId,
                            LocalDate start, LocalDate end)
            throws Exception {

        Customer c = customerRepo.findById(conn, customerId);
        if (c.getDriverAge() < 21)
            throw new InvalidDriverAgeException("Driver must be 21+");

        Car car = carRepo.findById(conn, carId);
        if (car == null || !car.isAvailable())
            throw new CarNotAvailableException("Car not available");

        return rentalRepo.create(conn, carId, customerId, start, end);
    }

    public void closeRental(Connection conn, int rentalId,
                            LocalDate returnDate, String method)
            throws Exception {

        Rental r = rentalRepo.findById(conn, rentalId);
        Car car = carRepo.findById(conn, r.getCarId());

        BigDecimal total = pricing.calculate(
                car.getDailyRate(),
                r.getStartDate(),
                r.getEndDate()
        );

        rentalRepo.close(conn, rentalId,
                java.sql.Date.valueOf(returnDate), total);

        paymentRepo.create(conn, rentalId, total, method);
    }
}