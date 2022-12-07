package com.sagen.accounts.services;

import com.sagen.accounts.entity.Customer;
import org.springframework.http.ResponseEntity;

public interface AccountServices {
    ResponseEntity<?> getAccountDetails(Customer customer);
}
