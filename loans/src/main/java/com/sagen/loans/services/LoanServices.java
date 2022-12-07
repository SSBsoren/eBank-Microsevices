package com.sagen.loans.services;

import com.sagen.loans.entity.Customer;
import org.springframework.http.ResponseEntity;

public interface LoanServices {
    ResponseEntity<?> getLoanDetails(Customer customer);
}
