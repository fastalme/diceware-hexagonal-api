package com.example.dicewarehexagonalapi.infra.config;

import com.example.dicewarehexagonalapi.app.entity.ErrorData;
import com.example.dicewarehexagonalapi.app.exception.InvalidWordCountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = InvalidWordCountException.class)
    public ResponseEntity<ErrorData> handler (InvalidWordCountException exception) {

        return ResponseEntity.badRequest()
                .body(new ErrorData(InvalidWordCountException.class.getSimpleName(), exception.getMessage()));

    }

}
