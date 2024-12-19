package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "savings")
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "target_description")
    private String targetDescription;

    @Column(name = "target_amount")
    private Double targetAmount;

    @Column(name = "current_amount")
    private Double currentAmount;

    @Column(name = "target_date")
    private LocalDate targetDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Saving() {
    }

    public Saving(String targetDescription, Double targetAmount, Double currentAmount, LocalDate targetDate) {
        this.id = id;
        this.targetDescription = targetDescription;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.targetDate = targetDate;
        this.createdDate = LocalDateTime.now();  // Thời gian hiện tại
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getTargetDescription() {
        return targetDescription;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    //Setters
    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}
