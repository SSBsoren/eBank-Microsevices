package com.sagen.accounts.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "cards")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private long cardId;


    @Column(name = "card_number")
    private String cardNumber;


    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private Long totalLimit;

    @Column(name = "amount_used")
    private Double amountUsed;

    @Column(name = "available_amount")
    private Double availableAmount;

    @Column(name = "created_on")
    private String createdOn;

}