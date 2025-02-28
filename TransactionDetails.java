package com.example.Bank_Management.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TransactionDetails")
@Data
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int accountNumber;

    @Column(nullable = false, updatable = false)
    private LocalDateTime transactiondateandtime;

    private String transactionStatus;


}
