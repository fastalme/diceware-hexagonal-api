package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.entity.WordSynonyms;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;

import java.util.List;

public class ForGettingFakeWordSynonyms implements ForGettingWordSynonyms {

    private static final String ANY_WORD = "any-word";
    private static final String ANY_SYNONYM = "any-synonym";

    @Override
    public WordSynonyms findSynonymsByWord (String word) {

        return new WordSynonyms(ANY_WORD, List.of(ANY_SYNONYM, ANY_SYNONYM));
        
    }

}
