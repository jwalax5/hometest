package com.any.hometest.controller;

import com.any.hometest.model.request.SendBitcoinRequest;
import com.any.hometest.model.request.WalletBalanceHistoryRequest;
import com.any.hometest.model.response.ApiResponse;
import com.any.hometest.model.response.SuccessResponse;
import com.any.hometest.model.response.WalletBalanceHistoryResponse;
import com.any.hometest.service.BitcoinTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("transactions")
public class BitcoinTransactionController {

    @Autowired
    BitcoinTransactionService bitcoinTransactionService;

    @PostMapping
    public ResponseEntity<? extends ApiResponse> sendBitcoin( @Valid @RequestBody SendBitcoinRequest request) {
        bitcoinTransactionService.sendBitcoin(request.getAmount(),request.getTransactionTime());
        SuccessResponse<String> response = new SuccessResponse<>("Send Bitcoin successfully");
        return new ResponseEntity<SuccessResponse>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<? extends ApiResponse> walletBalanceHistory( @Valid @RequestBody WalletBalanceHistoryRequest request) {
        List<WalletBalanceHistoryResponse> result = bitcoinTransactionService.getWalletBalanceHistory(request.getStartDatetime(), request.getEndDatetime());
        SuccessResponse<List<WalletBalanceHistoryResponse>> response = new SuccessResponse<>(result);
        return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
    }
}
