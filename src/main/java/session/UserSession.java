package session;

import databaseconnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserSession {

    private static UserSession instance;
    private String email;
    private String username;

    private UserSession(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public static void createSession(String email, String username) {
        instance = new UserSession(email, username);
    }

    public static UserSession getInstance() {
        return instance;
    }

    public String getEmail() {
        return email;
    }

    public String getUsernameFromSession() {
        return this.username;
        // Lấy email từ UserSession
//        UserSession session = UserSession.getInstance();
//        if (session == null) {
//            JOptionPane.showMessageDialog(null, "No Logged In Information!");
//            return null;
//        }
//
//        String email = session.getEmail();
//        if (email == null || email.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Invalid email in session!");
//            return null;
//        }
//
//        String query = "SELECT username FROM accounts WHERE email = ?";
//        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setString(1, email); // Đặt email làm tham số truy vấn
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return rs.getString("username"); // Lấy username từ kết quả truy vấn
//            } else {
//                JOptionPane.showMessageDialog(null, "Account not found!");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "SQL problem: " + ex.getMessage());
//        }
//        return null; // Trả về null nếu không tìm thấy
    }

    public static void clearSession() {
        instance = null;
    }
}
