package com.insignia.assessment.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private InvestmentGoal investmentGoal;

    @OneToOne(cascade = CascadeType.ALL)
    private Beneficiary beneficiary;

    private LocalDateTime createdAt;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setInvestmentGoal(InvestmentGoal investmentGoal) {
        this.investmentGoal = investmentGoal;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}