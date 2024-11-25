package main;

import javax.persistence.EntityManager;
import views.LoginAndRegister;
import utils.EntityManagerSingleton;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Khởi chạy ứng dụng
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EntityManager em = null;
                try {
                    // Khởi tạo EntityManager (mở kết nối với cơ sở dữ liệu)
                    em = EntityManagerSingleton.getEntityManager();

                    // Khởi tạo JFrame đầu tiên (LoginAndRegister)
                    LoginAndRegister loginAndRegisterFrame = new LoginAndRegister();
                    loginAndRegisterFrame.setVisible(true);  // Hiển thị JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        });
    }
}
