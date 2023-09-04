package com.saveIt.SavingApp.account;

import java.util.ArrayList;
import java.util.List;

import com.saveIt.SavingApp.transaction.Transaction;

import jakarta.persistence.*;

@Entity
@Table

public class Account {
    @Id
    private String id;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Transaction> transactions = new ArrayList<>();

    private String accountNumber;
    private String account_type;
    private Double balance;
    private String currency;
    private String owner;

    public Account() {

    }

    public Account(String id, String accountNumber, String account_type, Double balance, String currency,
            String owner) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.account_type = account_type;
        this.balance = balance;
        this.currency = currency;
        this.owner = owner;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getOwner() {
        return owner;

    }

    public void setOwner(String owner) {
        this.owner = owner;

    }

    public String getAccountNumber() {
        return accountNumber;

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;

    }

    public String getAccount_type() {
        return account_type;

    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;

    }

    public Double getBalance() {
        return balance;

    }

    public void setBalance(Double balance) {
        this.balance = balance;

    }

    public String getCurrency() {
        return currency;

    }

    public void setCurrency(String currency) {
        this.currency = currency;

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public void setTransactions(List<Transaction> transactions2) {
        this.transactions = transactions2;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
