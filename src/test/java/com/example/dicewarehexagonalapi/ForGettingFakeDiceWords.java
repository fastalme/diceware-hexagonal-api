package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDiceWords;

import java.util.Optional;

public class ForGettingFakeDiceWords implements ForGettingDiceWords {

    private static final String ANY_ID = "any-id";
    private static final String ANY_DICEWORD = "any-diceword";

    @Override
    public Optional<DiceWord> findById (String id) {

        return Optional.of(new DiceWord(ANY_ID, ANY_DICEWORD));

    }

}
