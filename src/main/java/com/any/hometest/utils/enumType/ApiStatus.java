package com.any.hometest.utils.enumType;

public enum ApiStatus {
    SUCCESS("Success"),
    FAILED("Failed");

    private final String status;

    ApiStatus(String status) {
        this.status = status;
    }
}
