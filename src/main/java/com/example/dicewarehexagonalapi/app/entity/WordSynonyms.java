package com.example.dicewarehexagonalapi.app.entity;

import java.util.List;

public class WordSynonyms {

    private final String word;
    private final List<String> synonyms;

    public WordSynonyms (String word, List<String> synonyms) {
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
