package models;

import java.time.LocalDate;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "money")
    private Double money;

    @Column(name = "description")
    private String description;

    @Column(name = "occurring_date")
    private LocalDate occurringDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Expense() {
    }

    public Expense(Double money, String description, LocalDate occurringDate) {
        this.money = money;
        this.description = description;
        this.occurringDate = occurringDate;
        this.createdDate = LocalDateTime.now();  // Thời gian hiện tại
    }

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getOccurringDate() {
        return occurringDate;
    }

    public void setOccurringDate(LocalDate occurringDate) {
        this.occurringDate = occurringDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
