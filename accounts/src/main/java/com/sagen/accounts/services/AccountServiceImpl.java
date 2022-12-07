package com.sagen.accounts.services;

import com.sagen.accounts.entity.Account;
import com.sagen.accounts.repository.AccountsRepository;
import com.sagen.accounts.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountServices {

    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public ResponseEntity<?> getAccountDetails(Customer customer) {
        Account account = accountsRepository.findByCustomerId(customer.getCustomerId());

        if (account == null) {
            ResponseEntity.ok("Account not found");
        }
        return ResponseEntity.ok(account);
    }
}
