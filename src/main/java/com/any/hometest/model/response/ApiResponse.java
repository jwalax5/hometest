package com.any.hometest.model.response;

import com.any.hometest.utils.enumType.ApiStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

@Data
public abstract class ApiResponse {
    private ApiStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ssXXX", timezone = "Asia/Tokyo")
    private Date timestamp = new Date(System.currentTimeMillis());
    ApiResponse(ApiStatus status){
        this.status = status;
    }
}
