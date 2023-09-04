package com.saveIt.SavingApp.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner AccountCommandLineRunner(AccountRepository repository) {
        return args -> {
            Account acc123 = new Account("acc123", "********1234", "Checking", 15000.25, "NOK", "Alice");
            Account acc456 = new Account("acc456", "********5678", "Savings", 25000.75, "NOK", "Bob");
            Account acc789 = new Account("acc789", "********9876", "Checking", 2000.50, "NOK", "Charlie");
            Account acc012 = new Account("acc012", "********2109", "Savings", 8000.00, "NOK", "David");

            repository.saveAll(List.of(acc123, acc456, acc789, acc012));
        };
    }
}
