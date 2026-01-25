package edu.aitu.oop3.service;

import edu.aitu.oop3.repo.CarRepository;
import edu.aitu.oop3.model.Car;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CarInventoryService {

    private final CarRepository repo = new CarRepository();

    public List<Car> search(Connection conn, Date start, Date end) throws Exception {
        return repo.findAvailable(conn, start, end);
    }
}
