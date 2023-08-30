package com.example.dicewarehexagonalapi.infra.wordsapi;

import java.util.List;

public class WordsAPISynonyms {

    private final String word;
    private final List<String> synonyms;

    public WordsAPISynonyms (String word, List<String> synonyms) {
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
