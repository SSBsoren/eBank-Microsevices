package com.sagen.accounts.repository;

import com.sagen.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

    Account findByCustomerId(Long customerId);

}
