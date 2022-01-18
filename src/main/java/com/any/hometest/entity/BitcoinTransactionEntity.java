package com.any.hometest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name="bitcoin_transaction")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BitcoinTransactionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private long id;

    @Column(name="amount",nullable = false)
    private int amount;

    @Column(name="transactionTime",nullable = false)
    private LocalDateTime transactionTime;

}
