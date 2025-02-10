package com.example.Bank_Management.AccountRepository;

import com.example.Bank_Management.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Integer> {
    

}
