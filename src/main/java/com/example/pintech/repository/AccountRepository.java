package com.example.pintech.repository;

import com.example.pintech.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByAccountNumber(String accountNumber);
}
