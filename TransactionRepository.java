package com.example.Bank_Management.AccountRepository;

import com.example.Bank_Management.Model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRespository extends JpaRepository<TransactionDetails, Integer> {

    @Query(value = "select * from transaction_details where account_number = :accNo", nativeQuery = true)
    List<TransactionDetails> getByAccountNumber(@Param("accNo") int accNo);


}
