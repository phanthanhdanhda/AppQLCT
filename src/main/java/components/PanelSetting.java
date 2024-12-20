package components;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import databaseconnection.DatabaseConnection;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.mindrot.jbcrypt.BCrypt;
import session.UserSession;
import views.LoginAndRegister;
import views.MainFrame;
//import com.formdev.flatlaf.FlatDarkLaf;
//import com.formdev.flatlaf.FlatLightLaf;

public class PanelSetting extends javax.swing.JPanel {

    private MainFrame parentFrame;  // Tham chiếu đến MainFrame

    public PanelSetting(MainFrame _parentFrame) {
        this.parentFrame = _parentFrame;  // Lưu đối tượng MainFrame vào trường
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnpass = new swing.Button();
        btnSignOut = new swing.Button();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Setting");

        btnpass.setBackground(new java.awt.Color(255, 204, 51));
        btnpass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnpass.setText("Change Password");
        btnpass.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpassActionPerformed(evt);
            }
        });

        btnSignOut.setBackground(new java.awt.Color(255, 51, 0));
        btnSignOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSignOut.setText("Sign Out");
        btnSignOut.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpass, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpassActionPerformed
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Các nhãn và trường nhập liệu
        JLabel lblOldPassword = new JLabel("Old password:");
        JPasswordField txtOldPassword = new JPasswordField(15);
        JLabel lblNewPassword = new JLabel("New password:");
        JPasswordField txtNewPassword = new JPasswordField(15);
        JLabel lblConfirmPassword = new JLabel("Confirm new password:");
        JPasswordField txtConfirmPassword = new JPasswordField(15);

        // Thêm các thành phần vào panel
        panel.add(lblOldPassword);
        panel.add(txtOldPassword);
        panel.add(lblNewPassword);
        panel.add(txtNewPassword);
        panel.add(lblConfirmPassword);
        panel.add(txtConfirmPassword);

        // Tạo nút xác nhận thay đổi mật khẩu
        int option = JOptionPane.showConfirmDialog(this, panel, "Change password", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String oldPassword = new String(txtOldPassword.getPassword());
            String newPassword = new String(txtNewPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());

            // Kiểm tra mật khẩu cũ
            try {
                if (checkOldPassword(oldPassword)) {
                    // Kiểm tra mật khẩu mới
                    if (newPassword.length() >= 6) {
                        // Kiểm tra mật khẩu xác nhận
                        if (newPassword.equals(confirmPassword)) {
                            // Cập nhật mật khẩu mới
                            updatePassword(newPassword);
                            JOptionPane.showMessageDialog(this, "Password has been changed successfully!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Confirmation password does not match!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "New password must be at least 6 characters!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Old password is incorrect!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error when changing password: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnpassActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
        parentFrame.setVisible(false);
        // Tạo và hiển thị lại cửa sổ đăng nhập
        LoginAndRegister loginandresister = new LoginAndRegister();  // Giả sử bạn có lớp LoginFrame
        loginandresister.setVisible(true);  // Hiển thị cửa sổ đăng nhập
    }//GEN-LAST:event_btnSignOutActionPerformed
    private boolean checkOldPassword(String oldPassword) throws SQLException {
        UserSession session = UserSession.getInstance();
        if (session == null) {
            JOptionPane.showMessageDialog(this, "Not logged in or user not found!");
            return false;
        }

        // Lấy tên người dùng từ phiên hiện tại
        String email = session.getEmail();

        // Lấy mật khẩu đã mã hóa từ cơ sở dữ liệu
        String query = "SELECT password FROM accounts WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email); // Sử dụng tên người dùng từ UserSession
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // Kiểm tra mật khẩu cũ
                return BCrypt.checkpw(oldPassword, storedPassword);
            }
        }
        return false; // Trả về false nếu không tìm thấy người dùng hoặc mật khẩu cũ sai
    }

    private void updatePassword(String newPassword) throws SQLException {
        UserSession session = UserSession.getInstance();
        if (session == null) {
            JOptionPane.showMessageDialog(this, "Not logged in or user not found!");
            return;
        }

        // Lấy email từ phiên hiện tại
        String email = session.getEmail();

        // Mã hóa mật khẩu mới
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        // Cập nhật mật khẩu mới trong cơ sở dữ liệu
        String query = "UPDATE accounts SET password = ? WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hashedPassword);  // Đặt mật khẩu đã mã hóa
            stmt.setString(2, email);        // Đặt tên người dùng từ phiên
            stmt.executeUpdate();               // Cập nhật cơ sở dữ liệu
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSignOut;
    private swing.Button btnpass;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
