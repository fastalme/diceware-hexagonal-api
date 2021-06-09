package com.example.dicewarehexagonalapi.app.entity;

public class ErrorData {

    private final String errorCode;
    private final String errorMessage;

    public ErrorData (String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode () {
        return errorCode;
    }

    public String getErrorMessage () {
        return errorMessage;
    }

}
