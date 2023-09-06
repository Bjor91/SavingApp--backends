package com.saveIt.SavingApp.transaction;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;

    }

    @GetMapping
    public List<Transaction> getAccounts() {
        return transactionService.getTransactions();

    }

    @PostMapping
    public void registerNewTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);

    }

    @PostMapping("/loadFromExcel")
    public ResponseEntity<String> loadTransactionsFromExcel() {
        try {
            transactionService.loadTransactionsFromExcel();
            return ResponseEntity.ok("Transactions loaded from Excel successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to load transactions from Excel: " + e.getMessage());
        }
    }

    @DeleteMapping(path = "{transactionId}")
    public void deleteTransaction(
            @PathVariable("transactionId") String transactionId) {

        transactionService.deleteTransaction(transactionId);

    }
}
