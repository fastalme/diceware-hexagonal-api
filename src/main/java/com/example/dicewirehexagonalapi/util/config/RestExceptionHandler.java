package com.example.dicewirehexagonalapi.util.config;

import com.example.dicewirehexagonalapi.util.exception.DicerollsInvalidValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler (value = DicerollsInvalidValue.class)
    public ResponseEntity<ErrorData> handler (HttpServletRequest request, DicerollsInvalidValue exception) {

        return ResponseEntity.badRequest ()
                .body (new ErrorData (DicerollsInvalidValue.class.getSimpleName (), exception.getMessage ()));

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