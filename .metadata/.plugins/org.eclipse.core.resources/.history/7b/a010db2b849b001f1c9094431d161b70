package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO303 {
    private static final String URL = "jdbc:mysql://localhost:3307/cineman?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "Duy0509@";
    private static Connection con; // Biến kết nối tĩnh

    public DAO303() {
        try {
            // Đảm bảo driver JDBC MySQL được tải
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (con == null || con.isClosed()) {
                synchronized (DAO303.class) {
                    if (con == null || con.isClosed()) {
                        con = DriverManager.getConnection(URL, USER, PASSWORD); // Khởi tạo kết nối
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                synchronized (DAO303.class) {
                    if (con == null || con.isClosed()) {
                        con = DriverManager.getConnection(URL, USER, PASSWORD); // Khởi tạo kết nối
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con; // Trả về kết nối
    }
}