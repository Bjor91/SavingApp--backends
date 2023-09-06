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
            Account brukskonto = new Account("brukskonto", "********1234", "Checking", 15000.25, "NOK", "Bob");
            Account sparekonto = new Account("sparekonto", "********5678", "Savings", 25000.75, "NOK", "Bob");

            repository.saveAll(List.of(brukskonto, sparekonto));
        };
    }
}
