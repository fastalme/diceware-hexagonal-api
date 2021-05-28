package com.example.dicewirehexagonalapi;

public class DicewareDTO {

    private final String phrase;

    public DicewareDTO (String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase () {
        return phrase;
    }

}
