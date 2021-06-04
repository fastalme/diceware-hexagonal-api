package com.example.dicewirehexagonalapi.util.exception;

public class DicerollsInvalidValue extends RuntimeException {

    public DicerollsInvalidValue () {
        super ("Dicerolls value must be between 2 and 8");
    }
}
