package edu.aitu.oop3.repo;

import edu.aitu.oop3.model.Customer;
import java.sql.*;

public class CustomerRepository {

    public Customer findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;

            return new Customer(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("driver_age")
            );
        }
    }
}
