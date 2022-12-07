package com.sagen.loans.services;

import com.sagen.loans.entity.Customer;
import com.sagen.loans.entity.Loans;
import com.sagen.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServicesImpl implements LoanServices {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public ResponseEntity<?> getLoanDetails(Customer customer) {
        List<Loans> loansList = loanRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());

        if (loansList == null) {
            ResponseEntity.ok("Account not found");
        }
        return ResponseEntity.ok(loansList);

    }
}
