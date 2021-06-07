package com.example.dicewarehexagonalapi.externalapis;

import java.util.List;

public class SynonymsResult {

    private final String word;
    private final List<String> synonyms;

    public SynonymsResult (String word, List<String> synonyms) {
        this.word = word;
        this.synonyms = synonyms;
    }

    public String getWord () {
        return word;
    }

    public List<String> getSynonyms () {
        return synonyms;
    }
}
