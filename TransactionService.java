package com.example.Bank_Management.AccountService;


import com.example.Bank_Management.AccountRepository.AccountRepository;
import com.example.Bank_Management.AccountRepository.TransactionRespository;
import com.example.Bank_Management.Model.TransactionDetails;
import com.example.Bank_Management.Model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRespository transactionrespo;

    @Autowired
    private AccountRepository accrepo;

    public String creditMoney(int accNo, int money) {

        Optional<UserAccount> account = accrepo.findById(accNo);

        if (account.isPresent()) {

            UserAccount useraccount = account.get();

            useraccount.setAccountBalance(useraccount.getAccountBalance() + money);

            TransactionDetails transaction= new TransactionDetails();

            transaction.setAccountNumber(useraccount.getAccountNumber());
            transaction.setTransactiondateandtime(LocalDateTime.now());
            transaction.setTransactionStatus("Your Account is Credited with "+ Integer.toString(money));

            accrepo.save(useraccount);

            transactionrespo.save(transaction);

            return "Transaction Successfully Completed...";
        } else {
            return "Account not found in Database...";
        }

    }

    public String debitMoney(int accNo, int money) {

        Optional<UserAccount> account = accrepo.findById(accNo);

        UserAccount useraccount = account.get();

        if (account.isPresent()) {

            if( useraccount.getAccountBalance()-money > 0) {

                useraccount.setAccountBalance(useraccount.getAccountBalance() - money);

                TransactionDetails transaction = new TransactionDetails();

                transaction.setAccountNumber(useraccount.getAccountNumber());
                transaction.setTransactiondateandtime(LocalDateTime.now());
                transaction.setTransactionStatus("Your Account is Debited with " + Integer.toString(money));

                accrepo.save(useraccount);

                transactionrespo.save(transaction);
            }
            else {

                TransactionDetails transaction = new TransactionDetails();

                transaction.setAccountNumber(useraccount.getAccountNumber());
                transaction.setTransactiondateandtime(LocalDateTime.now());
                transaction.setTransactionStatus("Transaction Declined due to InSufficient Balance");

                transactionrespo.save(transaction);
                return "InSufficient Balance...";
            }

            return "Transaction Successfully Completed...";

        } else {
            return "Account not found in Database...";
        }
    }


    public List<TransactionDetails> getTransactionDetails(int accNo) {

        return transactionrespo.getByAccountNumber(accNo);

    }
}
