package com.sagen.loans.controller;

import com.sagen.loans.entity.Customer;
import com.sagen.loans.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {


    @Autowired
    LoanServices loanServices;

    @PostMapping("/myLoans")
    public ResponseEntity<?> getLoanDetails(@RequestBody Customer customer) {
    	System.out.println("Invoking loans Microservice");
        return loanServices.getLoanDetails(customer);
    }

}
