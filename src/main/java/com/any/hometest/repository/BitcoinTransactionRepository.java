package com.any.hometest.repository;

import com.any.hometest.entity.BitcoinTransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BitcoinTransactionRepository extends CrudRepository<BitcoinTransactionEntity, Long> {
    @Query(value = "SELECT SUM(bt.amount) as amount,  FORMATDATETIME(bt.transaction_time,'yyyy-MM-dd HH:00:00') as transaction_time  " +
            "FROM bitcoin_transaction as bt " +
            "WHERE transaction_time >= ?1 " +
            "AND transaction_time <= ?2 " +
            "GROUP BY transaction_time " +
            "ORDER by transaction_time ASC", nativeQuery = true)
    List<Object[]> findHistoryTransaction(LocalDateTime transactionTimeStart, LocalDateTime transactionTimeEnd);
}
