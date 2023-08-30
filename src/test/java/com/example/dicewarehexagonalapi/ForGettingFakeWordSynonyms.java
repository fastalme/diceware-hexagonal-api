package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.entity.SynonymList;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;

import java.util.List;

public class ForGettingFakeWordSynonyms implements ForGettingWordSynonyms {

    private static final String ANY_SYNONYM = "any-synonym";

    @Override
    public SynonymList findSynonymsByWord (String word) {

        return new SynonymList(List.of(ANY_SYNONYM, ANY_SYNONYM));

    }

}
