package edu.aitu.oop3.repo;

import edu.aitu.oop3.model.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    public List<Car> findAvailable(Connection conn, Date start, Date end) throws SQLException {
        String sql = """
            SELECT * FROM cars c
            WHERE NOT EXISTS (
                SELECT 1 FROM rentals r
                WHERE r.car_id = c.id
                  AND r.status = 'OPEN'
                  AND NOT (r.end_date < ? OR r.start_date > ?)
            )
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, start);
            ps.setDate(2, end);
            ResultSet rs = ps.executeQuery();

            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getBigDecimal("daily_rate"),
                        rs.getBoolean("is_available")
                ));
            }
            return cars;
        }
    }

    public Car findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM cars WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;

            return new Car(
                    rs.getInt("id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getBigDecimal("daily_rate"),
                    rs.getBoolean("is_available")
            );
        }
    }
}
