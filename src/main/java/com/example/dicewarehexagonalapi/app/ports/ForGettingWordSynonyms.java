package com.example.dicewarehexagonalapi.app.ports;

import com.example.dicewarehexagonalapi.app.entity.SynonymList;

public interface ForGettingWordSynonyms {

    SynonymList findSynonymsByWord (String word);

}
