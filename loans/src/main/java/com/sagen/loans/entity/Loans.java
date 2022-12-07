package com.sagen.loans.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "loans")
@Data
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_number")
    private long loanNumber;


    @Column(name = "customer_id")
    private Long customerId;


    @Column(name = "total_loan")
    private Long total_loan;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "outstanding_amount")
    private Double outstandingAmount;

    @Column(name = "created_on")
    private String createdOn;

}