package com.pimaua87;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseConnectionTest {
    private static final String URL = "jdbc:mysql://localhost:3306/homework_26";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Test
    void getConnection() throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            assertTrue(con.isValid(1));
            assertFalse(con.isClosed());
        }
    }
}