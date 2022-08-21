package com.example.dicewarehexagonalapi.util.config;

import com.example.dicewarehexagonalapi.util.exception.InvalidWordCountValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler (value = InvalidWordCountValue.class)
    public ResponseEntity<ErrorData> handler (HttpServletRequest request, InvalidWordCountValue exception) {

        return ResponseEntity.badRequest ()
                .body (new ErrorData (InvalidWordCountValue.class.getSimpleName (), exception.getMessage ()));

    }

}

class ErrorData {

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