package com.example.dicewarehexagonalapi.app.entity;

import java.util.List;

public class SynonymList {

    private final List<String> synonyms;

    public SynonymList (List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getSynonyms () {
        return synonyms;
    }

}
