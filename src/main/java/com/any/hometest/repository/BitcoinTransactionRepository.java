package com.any.hometest.repository;

import com.any.hometest.entity.BitcoinTransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BitcoinTransactionRepository extends CrudRepository<BitcoinTransactionEntity, Long> {
    @Query(value = "SELECT subquery.total as amount, subquery.tt as transaction_time  " +
            "FROM (SELECT SUM(amount) as total, FORMATDATETIME(bt.transaction_time,'yyyy-MM-dd HH:00:00') as tt " +
            "FROM bitcoin_transaction as bt " +
            "GROUP BY FORMATDATETIME(bt.transaction_time,'yyyy-MM-dd HH:00:00')) as subquery " +
            "WHERE subquery.tt >= ?1 " +
            "AND subquery.tt <= ?2 ", nativeQuery = true)
    List<Object[]> findHistoryTransaction(LocalDateTime transactionTimeStart, LocalDateTime transactionTimeEnd);
}
