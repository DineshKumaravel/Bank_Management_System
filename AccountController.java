package com.example.Bank_Management.AccountController;
import com.example.Bank_Management.AccountService.AccountService;
import com.example.Bank_Management.Model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/account-details/{accNo}")
    public Optional<UserAccount> getAccountDetails(@PathVariable int accNo){
        return accountService.getAccountDetails(accNo);
    }

//    @PostMapping("/add-account")
//    public String addAccount(@RequestBody List<UserAccount> useraccount){
//         return accountService.addAccount(useraccount);
//    }

    @PutMapping("/account-number/{accNo}/credit/{money}")
    public String creditMoney(@PathVariable int accNo, @PathVariable int money){
        return accountService.creditMoney(accNo,money);
    }

    @PutMapping("/account-number/{accNo}/debit/{money}")
    public String debitMoney(@PathVariable int accNo, @PathVariable int money){
        return accountService.debitMoney(accNo,money);
    }
}
