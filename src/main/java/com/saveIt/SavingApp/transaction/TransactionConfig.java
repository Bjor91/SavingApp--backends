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

            transactions.addAll(TransactionGenerator.generateTransactionsFromExcel());
            repository.saveAll(transactions);
        };
    }
}
