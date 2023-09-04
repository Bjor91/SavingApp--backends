package com.saveIt.SavingApp.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveIt.SavingApp.transaction.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;

    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getTransactionsByAccountId(String accountId) {
        return accountRepository.findTransactionsByAccount(accountId);
    }

    public void addNewAccount(Account account) {
        Optional<Account> accountById = accountRepository.findById(account.getId());
        if (accountById.isPresent()) {
            throw new IllegalStateException("account with id " + account.getId() + " already exists");
        }
        accountRepository.save(account);
    }

    public void deleteAccount(String accountId) {
        boolean exists = accountRepository.existsById(accountId);
        if (!exists) {
            throw new IllegalStateException("account with id " + accountId + " does not exists");
        }
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void updateAccount(String accountId, Double balance) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException("account with id " + accountId + " does not exists"));

        if (balance != null && balance > 0 && !balance.equals(account.getBalance())) {
            account.setBalance(balance);
        }
    }
}
