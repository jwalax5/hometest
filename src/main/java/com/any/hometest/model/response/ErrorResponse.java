package com.any.hometest.model.response;

import com.any.hometest.utils.enumType.ApiStatus;

public class ErrorResponse extends ApiResponse{
    public String errorMessage;

    public ErrorResponse (String errorMessage){
        super(ApiStatus.FAILED);
        this.errorMessage= errorMessage;
    }
}
