package com.insignia.assessment.model;

public record ClientRequest(

        String clientName,
        Double annualIncome,

        ContactDetails contactDetails,
        InvestmentGoal investmentGoal,
        Beneficiary beneficiary

) {

    public record ContactDetails(
            String email,
            String phone,
            Address address
    ) {}

    public record Address(
            String unitNumber,
            String street,
            String city,
            String state,
            String postcode,
            String country
    ) {}

    public record InvestmentGoal(
            String goalName,
            Double targetAmount,
            Integer periodYears,
            Integer initialInvestmentAmount
    ) {}

    public record Beneficiary(
            String name,
            String relation
    ) {}
}
