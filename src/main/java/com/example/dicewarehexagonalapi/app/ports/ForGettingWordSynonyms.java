package com.example.dicewarehexagonalapi.app.ports;

import com.example.dicewarehexagonalapi.app.entity.WordSynonyms;

public interface ForGettingWordSynonyms {

    WordSynonyms findSynonymsByWord (String word);

}
