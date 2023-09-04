package com.saveIt.SavingApp.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionGenerator {

    public static List<Transaction> generateTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        String[] accountIds = { "acc123", "acc456", "acc789", "acc012" };
        String[] descriptions = {
                "Grocery Store", "Online Shopping", "Lunch Out"
        };
        String[] currencies = { "NOK" };
        String[] dates = generateRandomAugustDates(100); // Generate 100 random dates in August

        Random random = new Random();

        int transactionIndex = 9;
        for (int i = 0; i < dates.length; i++) {
            for (String accountId : accountIds) {
                String txnId = "txn" + String.format("%03d", transactionIndex++);
                String date = dates[i];
                String description = descriptions[random.nextInt(descriptions.length)];
                double amount = (random.nextDouble() * 100) * -1; // Negative random amount between 0 and -100
                String currency = currencies[0];
                transactions.add(new Transaction(txnId, date, description, amount, currency, accountId));
            }
        }

        return transactions;
    }

    public static String[] generateRandomAugustDates(int count) {
        String[] dates = new String[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int day = random.nextInt(31) + 1; // Random day between 1 and 31
            dates[i] = "2023-08-" + String.format("%02d", day);
        }
        return dates;
    }
}
