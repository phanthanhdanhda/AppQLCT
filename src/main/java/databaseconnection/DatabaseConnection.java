package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLCT;encrypt=true;trustServerCertificate=true;user=admin;password=123;";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";
    
    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
