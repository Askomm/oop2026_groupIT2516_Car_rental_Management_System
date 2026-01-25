package edu.aitu.oop3.db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.zsyuygmtfjoplddcqdjw";
    private static final String PASSWORD = loadPassword();

    private DatabaseConnection() {}

    private static String loadPassword() {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
            return props.getProperty("DB_PASSWORD");
        } catch (Exception e) {
            throw new RuntimeException("Cannot load DB_PASSWORD", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}