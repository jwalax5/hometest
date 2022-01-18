package com.any.hometest.model.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import java.time.OffsetDateTime;

@Data
public class SendBitcoinRequest {
    @Min(value=0,message = "Amount cannot be less than 0")
    private int amount;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime transactionTime;
}
