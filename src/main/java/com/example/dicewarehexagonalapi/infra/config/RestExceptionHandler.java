package com.example.dicewarehexagonalapi.infra.config;

import com.example.dicewarehexagonalapi.app.entity.ErrorData;
import com.example.dicewarehexagonalapi.app.exception.DicerollsInvalidValue;
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
