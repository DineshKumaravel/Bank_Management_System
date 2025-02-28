package com.example.Bank_Management.AccountService;


import com.example.Bank_Management.AccountRepository.AccountRepository;
import com.example.Bank_Management.Model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountrepo;


    public Optional<UserAccount> getAccountDetails(int accNo) {

        return accountrepo.findById(accNo);
    }


    public String addAccount(List<UserAccount> useraccount) {

        accountrepo.saveAll(useraccount);
        return "New Account Successfully Created...";

    }




}
