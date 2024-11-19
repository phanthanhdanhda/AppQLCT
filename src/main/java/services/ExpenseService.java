package services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Expense;
import repositories.JpaUtil;

@Service
public class ExpenseService {

    public void addExpense(Double money, String description, LocalDate occurringDate) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Expense expense = new Expense(money, description, occurringDate);
            em.persist(expense);  // Lưu vào cơ sở dữ liệu
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

    public List<Expense> getAllExpenses() {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Sử dụng JPQL để lấy tất cả các Expense từ cơ sở dữ liệu
            String jpql = "SELECT e FROM Expense e";
            Query query = em.createQuery(jpql);

            // Thực thi truy vấn và lấy kết quả
            List<Expense> expenses = query.getResultList();
            return expenses;
        } finally {
            em.close();
        }
    }

    public Expense getExpenseById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            return em.find(Expense.class, id);  // Tìm đối tượng Expense theo ID
        } finally {
            em.close();
        }
    }

    public void deleteExpenseById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
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
        EntityManager em = JpaUtil.getEntityManager();
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

//    @Autowired
//    private ExpenseRepository expenseRepository;
//
//    // Thêm Expense vào cơ sở dữ liệu
//    public Expense addExpense(Double money, String description, LocalDateTime occurringDate) {
//        Expense expense = new Expense(money, description, occurringDate);
//        return expenseRepository.save(expense);  // Lưu vào database
//    }
//
//    // Lấy tất cả các Expense từ database
//    public List<Expense> getAllExpenses() {
//        return expenseRepository.findAll();  // Lấy danh sách Expense
//    }
//
//    // Xóa Expense theo ID
//    public void deleteExpenseById(Long id) {
//        expenseRepository.deleteById(id);
//    }
}
