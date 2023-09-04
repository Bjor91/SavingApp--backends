package com.saveIt.SavingApp.transaction;

import com.saveIt.SavingApp.account.Account;

import jakarta.persistence.*;

@Entity
@Table

public class Transaction {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Account account;

    private String account_id;
    private String date;
    private String description;
    private Double amount;
    private String currency;

    public Transaction() {

    }

    public Transaction(String id, String date, String description, Double amount, String currency, String account_id) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.account_id = account_id;

    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public Double getAmount() {
        return amount;

    }

    public void setAmount(Double amount) {
        this.amount = amount;

    }

    public String getCurrency() {
        return currency;

    }

    public void setCurrency(String currency) {
        this.currency = currency;

    }

    public String getAccount_id() {
        return account_id;

    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", account_id='" + account_id + '\'' +
                '}';
    }

}
