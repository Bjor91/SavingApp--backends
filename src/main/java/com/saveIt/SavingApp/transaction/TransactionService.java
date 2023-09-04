package com.saveIt.SavingApp.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;

    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        return transactionRepository.findTransactionsByAccountId(accountId);
    }

    public void addNewTransaction(Transaction transaction) {

        Optional<Transaction> transactionById = transactionRepository.findTransactionById(transaction.getId());

        if (transactionById.isPresent()) {
            throw new IllegalStateException("transaction already exists");
        }
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(String transactionId) {
        boolean exists = transactionRepository.existsById(transactionId);
        if (!exists) {
            throw new IllegalStateException("transaction with id " + transactionId + " does not exists");
        }
        transactionRepository.deleteById(transactionId);
    }
}
