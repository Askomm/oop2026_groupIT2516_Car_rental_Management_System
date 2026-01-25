package edu.aitu.oop3.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

public class PaymentRepository {

    public void create(Connection conn, int rentalId,
                       BigDecimal amount, String method) throws SQLException {
        String sql = """
            INSERT INTO payments (rental_id, paid_amount, payment_method)
            VALUES (?, ?, ?)
            """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rentalId);
            ps.setBigDecimal(2, amount);
            ps.setString(3, method);
            ps.executeUpdate();
        }
    }
}
