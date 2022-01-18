package com.any.hometest.model.response;

import com.any.hometest.utils.enumType.ApiStatus;

public class SuccessResponse<T> extends ApiResponse{
    public T result;

    public SuccessResponse (T result){
        super(ApiStatus.SUCCESS);
        this.result = result;
    }
}
