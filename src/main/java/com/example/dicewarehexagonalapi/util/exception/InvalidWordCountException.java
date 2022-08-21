package com.example.dicewarehexagonalapi.util.exception;

public class InvalidWordCountException extends RuntimeException {

    public InvalidWordCountException () {
        super ("Dicerolls value must be between 2 and 8");
    }

}
