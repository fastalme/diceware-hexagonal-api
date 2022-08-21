package com.example.dicewarehexagonalapi.util.exception;

public class InvalidWordCountValue extends RuntimeException {

    public InvalidWordCountValue () {
        super ("Dicerolls value must be between 2 and 8");
    }

}
