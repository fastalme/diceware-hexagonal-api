package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.externalapis.SynonymsResult;

import java.util.Arrays;

public class SynonymsResultFactory {

    private static final String ANY_WORD = "any-word";
    private static final String ANY_SYNONYM = "any-synonym";

    public static SynonymsResult createTwoElementsResult () {
        return new SynonymsResult (ANY_WORD,
                Arrays.asList (ANY_SYNONYM, ANY_SYNONYM));
    }

}
