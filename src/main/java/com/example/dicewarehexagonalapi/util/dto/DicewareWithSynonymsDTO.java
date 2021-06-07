package com.example.dicewarehexagonalapi.util.dto;

public class DicewareWithSynonymsDTO {

    private final String phrase;
    private final String synonymsPhrase;

    public DicewareWithSynonymsDTO (String phrase, String synonymsPhrase) {
        this.phrase = phrase;
        this.synonymsPhrase = synonymsPhrase;
    }

    public String getPhrase () {
        return phrase;
    }

    public String getSynonymsPhrase () {
        return synonymsPhrase;
    }

}
