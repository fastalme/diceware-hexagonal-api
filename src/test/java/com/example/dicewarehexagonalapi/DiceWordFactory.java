package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;

import java.util.Optional;

public class DiceWordFactory {

    private static final String ANY_ID = "any-id";
    private static final String ANY_DICEWORD = "any-diceword";

    public static Optional<DiceWord> createRandom () {
        return Optional.of (new DiceWord (ANY_ID,
                ANY_DICEWORD));
    }

    public static Optional<DiceWord> createRandom (String id) {
        return Optional.of (new DiceWord (id,
                ANY_DICEWORD));
    }

}
