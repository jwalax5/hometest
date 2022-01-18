package com.any.hometest.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BitcoinTransactionException extends RuntimeException{
    public BitcoinTransactionException(String exception) {
        super(exception);
    }
}
