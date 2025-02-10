package com.example.Bank_Management.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Accounts")
public class UserAccount {


    @Id
    private int accountNumber;
    private String userName;
    private String accountType;
    private int accountBalance;


    public UserAccount() {
    }

    public UserAccount(int accountNumber, String accountType, String userName, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.userName = userName;
        this.accountBalance = accountBalance;
    }
}
