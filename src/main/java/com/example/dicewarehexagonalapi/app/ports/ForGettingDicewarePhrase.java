package com.example.dicewarehexagonalapi.app.ports;

import java.util.List;

public interface ForGettingDicewarePhrase {

    String get(int wordCount);
    List<String> getWithSynonyms(int wordCount);

}
