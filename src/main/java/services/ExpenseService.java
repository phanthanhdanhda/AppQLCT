package services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Account;
import models.Expense;
import utils.CustomEntityManager;

@Service
public class ExpenseService {

    public void addExpense(Double money, String description, LocalDate occurringDate, Account account) {
        EntityManager em = CustomEntityManager.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Expense expense = new Expense(money, description, occurringDate, account);
            em.persist(expense);  // Lưu vào cơ sở dữ liệu
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Nếu có lỗi, rollback lại giao dịch
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Expense> getAllExpenses(String email) {
        EntityManager em = CustomEntityManager.getEntityManager();

        try {
            // Sử dụng JPQL để lấy tất cả các Expense từ cơ sở dữ liệu
            String jpql = "SELECT e FROM Expense e WHERE e.account.email = :email ORDER BY e.occurringDate ASC";
            Query query = em.createQuery(jpql);

            // Gán giá trị cho tham số 'email'
            query.setParameter("email", email); // Gán giá trị email vào truy vấn

            // Thực thi truy vấn và lấy kết quả
            List<Expense> expenses = query.getResultList();
            return expenses;
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public Expense getExpenseById(Long id) {
        EntityManager em = CustomEntityManager.getEntityManager();

        try {
            return em.find(Expense.class, id);  // Tìm đối tượng Expense theo ID
        } finally {
            em.close();
        }
    }

    public void deleteExpenseById(Long id) {
        EntityManager em = CustomEntityManager.getEntityManager();
        try {
            em.getTransaction().begin();
            Expense expense = em.find(Expense.class, id);
            if (expense != null) {
                em.remove(expense);  // Xóa bản ghi nếu tìm thấy
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback nếu có lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Expense updateExpense(Long id, Double money, String description, LocalDate occurringDate) {
        EntityManager em = CustomEntityManager.getEntityManager();
        Expense updatedExpense = null;
        try {
            em.getTransaction().begin();
            Expense expense = em.find(Expense.class, id);
            if (expense != null) {
                // Cập nhật thông tin mới
                expense.setMoney(money);
                expense.setDescription(description);
                expense.setOccurringDate(occurringDate);
                updatedExpense = em.merge(expense);  // Gọi merge để cập nhật
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback nếu có lỗi
            e.printStackTrace();
        } finally {
            em.close();
        }
        return updatedExpense;  // Trả về đối tượng Expense đã cập nhật
    }

}
