package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://ep-cool-sun-b2jbqf2e.c-6.eu-central-1.aws.neon.tech:5432/neondb";
    private static final String USER ="neondb_owner";
    private static final String PASSWORD ="npg_QZj0MoYNXe7v";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}