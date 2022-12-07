package com.sagen.accounts.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "customers")
public class Customer {

    @Column(name = "customer_id")
    @Id
    private Long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(name = "created_date")
    private LocalDate createdOn;


}
