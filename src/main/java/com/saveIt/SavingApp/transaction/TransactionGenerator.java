package com.saveIt.SavingApp.transaction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;

public class TransactionGenerator {

    public static List<Transaction> generateTransactionsFromExcel() throws Exception {
        List<Transaction> transactions = new ArrayList<>();

        // Load the Excel file from the classpath (assuming it's located under
        // /resources folder)
        InputStream is = new ClassPathResource("transaksjoner.xlsx").getInputStream();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row currentRow = sheet.getRow(i);

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
}
