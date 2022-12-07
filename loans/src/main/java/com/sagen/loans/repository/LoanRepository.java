package com.sagen.loans.repository;

import com.sagen.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Loans> {

    List<Loans> findByCustomerIdOrderByStartDateDesc(Long customerId);
}
