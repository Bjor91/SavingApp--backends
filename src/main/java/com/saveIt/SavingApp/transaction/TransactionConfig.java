package com.saveIt.SavingApp.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner TransActionCommandLineRunner(TransactionRepository repository) {
        return args -> {

            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            /*
             * Transaction txn001 = new Transaction("txn001", "2023-08-15", "Grocery Store",
             * -75.5, "NOK", "acc123");
             * Transaction txn002 = new Transaction("txn002", "2023-08-14",
             * "Paycheck Deposit", 40000.0, "NOK", "acc123");
             * Transaction txn003 = new Transaction("txn003", "2023-08-15",
             * "Online Shopping", -320.25, "NOK", "acc456");
             * Transaction txn004 = new Transaction("txn004", "2023-08-14",
             * "Interest Earnings", 50.25, "NOK", "acc456");
             * Transaction txn005 = new Transaction("txn005", "2023-08-15", "Rent Payment",
             * -1000.0, "NOK", "acc789");
             * Transaction txn006 = new Transaction("txn006", "2023-08-14",
             * "Savings Deposit", 1500.0, "NOK", "acc456");
             * Transaction txn007 = new Transaction("txn007", "2023-08-14",
             * "Savings Deposit", 1000.0, "NOK", "acc012");
             * Transaction txn008 = new Transaction("txn008", "2023-08-14",
             * "Paycheck Deposit", 26000.0, "NOK", "acc789");
             * Transaction txn009 = new Transaction("txn009", "2023-08-08",
             * "Savings Deposit", 2500.0, "NOK", "acc456");
             * Transaction txn010 = new Transaction("txn010", "2023-08-14",
             * "Savings Deposit", 2500.0, "NOK", "acc456");
             * Transaction txn011 = new Transaction("txn011", "2023-08-06",
             * "Savings Deposit", 7000.0, "NOK", "acc012");
             * Transaction txn012 = new Transaction("txn012", "2023-08-20",
             * "Savings Deposit", 7000.0, "NOK", "acc012");
             * Transaction txn013 = new Transaction("txn013", "2023-08-29",
             * "Online Shopping", -5000.0, "NOK", "acc012");
             * 
             * transactions.add(txn001);
             * transactions.add(txn002);
             * transactions.add(txn003);
             * transactions.add(txn004);
             * transactions.add(txn005);
             * transactions.add(txn006);
             * transactions.add(txn007);
             * transactions.add(txn008);
             * transactions.add(txn009);
             * transactions.add(txn010);
             * transactions.add(txn011);
             * transactions.add(txn012);
             * transactions.add(txn013);
             * 
             * transactions.addAll(TransactionGenerator.generateTransactions());
             */
            transactions.addAll(TransactionGenerator.generateTransactionsFromExcel());
            repository.saveAll(transactions);
        };
    }
}
