package com.saveIt.SavingApp.transaction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;

public class TransactionGenerator {
    /*
     * public static List<Transaction> generateTransactions() {
     * List<Transaction> transactions = new ArrayList<>();
     * 
     * String[] accountIds = { "acc123", "acc789" };
     * String[] descriptions = {
     * "Grocery Store", "Online Shopping", "Lunch Out"
     * };
     * String[] currencies = { "NOK" };
     * String[] dates = generateRandomAugustDates(100); // Generate 100 random dates
     * in August
     * 
     * Random random = new Random();
     * 
     * int transactionIndex = 14;
     * for (int i = 0; i < dates.length; i++) {
     * for (String accountId : accountIds) {
     * String txnId = "txn" + String.format("%03d", transactionIndex++);
     * String date = dates[i];
     * String description = descriptions[random.nextInt(descriptions.length)];
     * double amount = (random.nextDouble() * 100) * -1; // Negative random amount
     * between 0 and -100
     * String currency = currencies[0];
     * transactions.add(new Transaction(txnId, date, description, amount, currency,
     * accountId));
     * }
     * }
     * 
     * return transactions;
     * }
     * 
     * public static String[] generateRandomAugustDates(int count) {
     * String[] dates = new String[count];
     * Random random = new Random();
     * for (int i = 0; i < count; i++) {
     * int day = random.nextInt(31) + 1; // Random day between 1 and 31
     * dates[i] = "2023-08-" + String.format("%02d", day);
     * }
     * return dates;
     * }
     */
    public static List<Transaction> generateTransactionsFromExcel() throws Exception {
        List<Transaction> transactions = new ArrayList<>();

        // Load the Excel file from the classpath (assuming it's located under
        // /resources folder)
        InputStream is = new ClassPathResource("transaksjoner.xlsx").getInputStream();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // Skipping header row
            Row currentRow = sheet.getRow(i);

            // Check if row or cells are empty before processing
            if (currentRow == null)
                continue;

            String txnId = currentRow.getCell(0).toString();

            String date = currentRow.getCell(1).toString();
            String description = currentRow.getCell(2).toString();

            Double amount = currentRow.getCell(3).getNumericCellValue();
            String currency = currentRow.getCell(4).toString();
            String accountId = currentRow.getCell(5).toString();

            transactions.add(new Transaction(txnId, date, description, amount, currency, accountId));
        }

        workbook.close();
        is.close();
        return transactions;
    }
    /*
     * private static String safeCellValue(Cell cell) {
     * return (cell == null || cell.toString().trim().isEmpty()) ? "" :
     * cell.toString().trim();
     * }
     */
}
