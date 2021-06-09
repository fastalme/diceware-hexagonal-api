package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.entity.WordSynonyms;

import java.util.Arrays;

public class SynonymsResultFactory {

    private static final String ANY_WORD = "any-word";
    private static final String ANY_SYNONYM = "any-synonym";

    public static WordSynonyms createTwoElementsResult () {
        return new WordSynonyms (ANY_WORD,
                Arrays.asList (ANY_SYNONYM, ANY_SYNONYM));
    }

}
