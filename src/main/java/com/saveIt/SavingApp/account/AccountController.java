package com.saveIt.SavingApp.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saveIt.SavingApp.transaction.Transaction;
import com.saveIt.SavingApp.transaction.TransactionService;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {

    private final AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;

    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();

    }

    @PostMapping
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);

    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(
            @PathVariable("accountId") String accountId) {

        accountService.deleteAccount(accountId);

    }

    @PutMapping(path = "{accountId}")
    public void updateAccount(
            @PathVariable("accountId") String accountId,
            @RequestParam(required = false) Double balance) {

        accountService.updateAccount(accountId, balance);

    }

    @GetMapping(path = "{accountId}/withTransactions")
    public ResponseEntity<Account> getTransactionsByAccountId(@PathVariable("accountId") String accountId) {
        Optional<Account> accountOptional = accountService.getTransactionsByAccountId(accountId);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
            account.setTransactions(transactions);

            return ResponseEntity.ok(accountOptional.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
