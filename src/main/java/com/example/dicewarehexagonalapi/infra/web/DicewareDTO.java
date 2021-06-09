package com.example.dicewarehexagonalapi.infra.web;

public class DicewareDTO {

    private final String phrase;

    public DicewareDTO (String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase () {
        return phrase;
    }

}
