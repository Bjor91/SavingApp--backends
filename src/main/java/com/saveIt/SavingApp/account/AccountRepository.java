package com.saveIt.SavingApp.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    /*
     * @Query("SELECT s FROM Account s WHERE s.id = ?1")
     * Optional<Account> findAccountByString(String id);
     */
    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.transactions WHERE a.id = ?1")
    Optional<Account> findTransactionsByAccount(String id);

}
