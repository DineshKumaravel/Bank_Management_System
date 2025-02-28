package com.example.Bank_Management.AccountController;
import com.example.Bank_Management.AccountService.TransactionService;
import com.example.Bank_Management.Model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionserv;

    @PutMapping("/account-number/{accNo}/credit/{money}")
    public String creditMoney(@PathVariable int accNo, @PathVariable int money){
        return transactionserv.creditMoney(accNo,money);
    }

    @PutMapping("/account-number/{accNo}/debit/{money}")
    public String debitMoney(@PathVariable int accNo, @PathVariable int money){
        return transactionserv.debitMoney(accNo,money);
    }

    @GetMapping("/get-transaction-details/{accNo}")
    public List<TransactionDetails> getTransactionDetails(@PathVariable int accNo){

        return transactionserv.getTransactionDetails(accNo);

    }


}
