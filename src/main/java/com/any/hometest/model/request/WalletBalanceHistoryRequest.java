package com.any.hometest.model.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class WalletBalanceHistoryRequest {
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime startDatetime;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime endDatetime;
}
