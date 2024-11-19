package services;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Saving;
import repositories.JpaUtil;

public class SavingService {
    public void addSaving(Double targetAmount, Double currentAmount, LocalDate targetDate) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Saving saving = new Saving(targetAmount, currentAmount, targetDate);
            em.persist(saving);  // Lưu vào cơ sở dữ liệu
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

    public List<Saving> getAllSavings() {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Sử dụng JPQL để lấy tất cả các Saving từ cơ sở dữ liệu
            String jpql = "SELECT s FROM Saving s";
            Query query = em.createQuery(jpql);

            // Thực thi truy vấn và lấy kết quả
            List<Saving> savings = query.getResultList();
            return savings;
        } finally {
            em.close();
        }
    }

    public Saving getSavingById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            return em.find(Saving.class, id);  // Tìm đối tượng Saving theo ID
        } finally {
            em.close();
        }
    }

    public void deleteSavingById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Saving saving = em.find(Saving.class, id);
            if (saving != null) {
                em.remove(saving);  // Xóa bản ghi nếu tìm thấy
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback nếu có lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Saving updateSaving(Long id, Double targetAmount, Double currentAmount, LocalDate targetDate) {
        EntityManager em = JpaUtil.getEntityManager();
        Saving updatedSaving = null;
        try {
            em.getTransaction().begin();
            Saving saving = em.find(Saving.class, id);
            if (saving != null) {
                // Cập nhật thông tin mới
                saving.setTargetAmount(targetAmount);
                saving.setCurrentAmount(currentAmount);
                saving.setTargetDate(targetDate);
                updatedSaving = em.merge(saving);  // Gọi merge để cập nhật
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback nếu có lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }
        return updatedSaving;  // Trả về đối tượng Saving đã cập nhật
    }
}
