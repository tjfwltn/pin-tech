package com.example.pintech.service;

import com.example.pintech.entity.AccountEntity;
import com.example.pintech.entity.TransferHistoryEntity;
import com.example.pintech.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountEntity createAccount(AccountEntity account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(AccountEntity account) {
        accountRepository.delete(account);
    }

    public Long withdrawMoney(Long accountId, Long money) {
        accountRepository.findById(accountId).ifPresent(account -> {
            Long balance = account.getBalance();
            if (balance < money) {
                System.out.println("error");
            }
            account.setBalance(balance - money);
            accountRepository.save(account);
        });

        return money;
    }
    public void depositMoney(Long accountId, Long money) {
        accountRepository.findById(accountId).ifPresent(account -> {
            account.setBalance(account.getBalance() + money);
        });
    }

    public void transferMoney(Long accountId, Long money, String accountNumber) {
        AccountEntity receiver = accountRepository.findByAccountNumber(accountNumber);
        accountRepository.findById(accountId).ifPresent(account -> {
            withdrawMoney(accountId, money);
            receiver.setBalance(receiver.getBalance() + money);
        });
    }

    public void checkTransferHistory(Long accountId) {
        accountRepository.findById(accountId).ifPresent(account -> {
            List<TransferHistoryEntity> transferHistories = account.getTransferHistories();

            if (transferHistories.isEmpty()) {
                System.out.println("error");
            }
            transferHistories.forEach(history -> {
                System.out.println("history.getTransferDate() = " + history.getTransferDate());
            });
        });
    }
}
