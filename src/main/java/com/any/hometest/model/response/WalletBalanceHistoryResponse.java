package com.any.hometest.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
public class WalletBalanceHistoryResponse {
    private int amount;

    private OffsetDateTime transactionTime;
}
