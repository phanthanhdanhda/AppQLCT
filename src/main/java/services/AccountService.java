package services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import models.Account;
import org.mindrot.jbcrypt.BCrypt;
import utils.CustomEntityManager;

public class AccountService {

    public boolean registerUser(String username, String email, String password) {
        EntityManager em = CustomEntityManager.getEntityManager();        // Tạo mới EntityManager
        EntityTransaction transaction = em.getTransaction();

        try {
            // Kiểm tra email đã tồn tại hay chưa
            String query = "SELECT COUNT(a) FROM Account a WHERE a.email = :email";
            List<Long> result = em.createQuery(query, Long.class)
                    .setParameter("email", email)
                    .getResultList();
            Long count = result.isEmpty() ? 0 : result.get(0);
            if (count > 0) {
                return false; // Email đã tồn tại
            }

            // Mã hóa mật khẩu
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            // Tạo và lưu tài khoản mới
            Account account = new Account(username, email, hashedPassword);
            transaction.begin();
            em.persist(account); // Lưu vào cơ sở dữ liệu
            transaction.commit();
            return true; // Đăng ký thành công
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback nếu có lỗi
            }
            e.printStackTrace();
            return false; // Đăng ký thất bại
        } finally {
            em.close();
        }
    }

    public String loginUser(String email, String password) {
        EntityManager em = CustomEntityManager.getEntityManager();

        try {
            // Truy vấn tài khoản theo email
            String query = "SELECT a FROM Account a WHERE a.email = :email";
            Account account = em.createQuery(query, Account.class)
                    .setParameter("email", email)
                    .getResultList() // Lấy tất cả kết quả và kiểm tra
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (account != null) {
                // Kiểm tra mật khẩu
                if (BCrypt.checkpw(password, account.getPassword())) {
                    return account.getUsername(); // Trả về username nếu đăng nhập thành công
                }
            }
            return null; // Trả về null nếu đăng nhập thất bại
        } catch (RuntimeException e) {
            // Bạn có thể thay thế e.printStackTrace() bằng việc log lỗi nếu cần
            e.printStackTrace();
            return null; // Xử lý lỗi nếu có
        } finally {
            em.close();
        }
    }

}
