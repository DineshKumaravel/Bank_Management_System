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

    @PostMapping("/add-account")
    public String addAccount(@RequestBody List<UserAccount> useraccount){
         return accountService.addAccount(useraccount);
    }


}
