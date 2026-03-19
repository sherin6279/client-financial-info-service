package com.insignia.assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class InvestmentGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;
    private Double targetAmount;
    private Integer periodYears;
    private Integer initialInvestmentAmount;

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void setPeriodYears(Integer periodYears) {
        this.periodYears = periodYears;
    }

    public void setInitialInvestmentAmount(Integer initialInvestmentAmount) {
        this.initialInvestmentAmount = initialInvestmentAmount;
    }
}
