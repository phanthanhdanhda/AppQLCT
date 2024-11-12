package services;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Expense;
import models.Receipt;
import repositories.JpaUtil;

@Service
public class ReceiptService {
    public void addReceipt(Double money, String description, LocalDate occurringDate) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Receipt receipt = new Receipt(money, description, occurringDate);
            em.persist(receipt);  // Lưu vào cơ sở dữ liệu
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Nếu có lỗi, rollback lại giao dịch
            }
            e.printStackTrace();
        } finally {
            em.close();  // Đảm bảo đóng EntityManager
        }
    }

    public List<Receipt> getAllReceipts() {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Sử dụng JPQL để lấy tất cả các Expense từ cơ sở dữ liệu
            String jpql = "SELECT e FROM Receipt e";
            Query query = em.createQuery(jpql);

            // Thực thi truy vấn và lấy kết quả
            List<Receipt> receipts = query.getResultList();
            return receipts;
        } finally {
            em.close();
        }
    }

    public Receipt getReceiptById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            return em.find(Receipt.class, id);  // Tìm đối tượng Receipt theo ID
        } finally {
            em.close();
        }
    }
    public void deleteReceiptById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Receipt receipt = em.find(Receipt.class, id);
            if (receipt != null) {
                em.remove(receipt);  // Xóa bản ghi nếu tìm thấy
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback nếu có lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Receipt updateReceipt(Long id, Double money, String description, LocalDate occurringDate) {
        EntityManager em = JpaUtil.getEntityManager();
        Receipt updatedReceipt = null;
        try {
            em.getTransaction().begin();
            Receipt receipt = em.find(Receipt.class, id);
            if (receipt != null) {
                // Cập nhật thông tin mới
                receipt.setMoney(money);
                receipt.setDescription(description);
                receipt.setOccurringDate(occurringDate);
                updatedReceipt = em.merge(receipt);  // Gọi merge để cập nhật
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback nếu có lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }
        return updatedReceipt;  // Trả về đối tượng Expense đã cập nhật
    }
}
