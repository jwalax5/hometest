package com.any.hometest.service;

import com.any.hometest.entity.BitcoinTransactionEntity;
import com.any.hometest.model.response.WalletBalanceHistoryResponse;
import com.any.hometest.repository.BitcoinTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BitcoinTransactionService {

    @Autowired
    BitcoinTransactionRepository bitcoinTransactionRepository;

    public BitcoinTransactionEntity sendBitcoin(int amount, OffsetDateTime transactionTime)
    {
        BitcoinTransactionEntity entity = new BitcoinTransactionEntity();
        entity.setAmount(amount);
        entity.setTransactionTime(transactionTime.toLocalDateTime());
        return bitcoinTransactionRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<WalletBalanceHistoryResponse> getWalletBalanceHistory(OffsetDateTime startDatetime, OffsetDateTime endDateTime)
    {
        ZoneOffset zone = ZoneOffset.of("+00:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Object[]> result =  bitcoinTransactionRepository.findHistoryTransaction(startDatetime.toLocalDateTime(),endDateTime.toLocalDateTime());
        return result.stream()
                .map(i -> new WalletBalanceHistoryResponse(((BigInteger) i[0]).intValue(),
                        OffsetDateTime.of(LocalDateTime.parse((String) i[1],formatter),zone)))
                .collect(Collectors.toList());
    }
}
