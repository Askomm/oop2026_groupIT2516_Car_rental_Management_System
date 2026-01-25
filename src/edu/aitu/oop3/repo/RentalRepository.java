package edu.aitu.oop3.repo;

import edu.aitu.oop3.model.Rental;
import java.sql.*;
import java.time.LocalDate;

public class RentalRepository {

    public int create(Connection conn, int carId, int customerId,
                      LocalDate start, LocalDate end) throws SQLException {

        String sql = """
            INSERT INTO rentals (car_id, customer_id, start_date, end_date, status)
            VALUES (?, ?, ?, ?, 'OPEN') RETURNING id
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, carId);
            ps.setInt(2, customerId);
            ps.setDate(3, Date.valueOf(start));
            ps.setDate(4, Date.valueOf(end));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    public Rental findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM rentals WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;

            return new Rental(
                    rs.getInt("id"),
                    rs.getInt("car_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("start_date").toLocalDate(),
                    rs.getDate("end_date").toLocalDate(),
                    rs.getDate("return_date") == null ? null :
                            rs.getDate("return_date").toLocalDate(),
                    rs.getBigDecimal("total_cost"),
                    rs.getString("status")
            );
        }
    }

    public void close(Connection conn, int rentalId, Date returnDate, java.math.BigDecimal cost)
            throws SQLException {
        String sql = """
            UPDATE rentals
            SET return_date = ?, total_cost = ?, status = 'CLOSED'
            WHERE id = ?
            """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, returnDate);
            ps.setBigDecimal(2, cost);
            ps.setInt(3, rentalId);
            ps.executeUpdate();
        }
    }
}
