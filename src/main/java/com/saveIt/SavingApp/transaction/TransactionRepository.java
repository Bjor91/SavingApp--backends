package com.saveIt.SavingApp.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("SELECT t FROM Transaction t WHERE t.account_id = ?1")
    Optional<Transaction> findTransactionById(String id);

    @Query("SELECT t FROM Transaction t WHERE t.account_id = ?1")
    List<Transaction> findTransactionsByAccountId(String accountId);
}
