// DemoUsersExample.java
package edu.aitu.oop3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoUsersExample {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            createTableIfNeeded(connection);
            insertUser(connection, "Alice", "alice@example.com");
            insertUser(connection, "Jacob", "bob@example.com");
            printAllUsers(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableIfNeeded(Connection connection) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS demo_users (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL
            );
            """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    private static void insertUser(Connection connection, String name, String email) throws SQLException {
        String sql = """
            INSERT INTO demo_users (name, email)
            VALUES (?, ?)
            ON CONFLICT (email) DO NOTHING;
            """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        }
    }

    private static void printAllUsers(Connection connection) throws SQLException {
        String sql = "SELECT id, name, email FROM demo_users ORDER BY id";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email")
                );
            }
        }
    }
}
