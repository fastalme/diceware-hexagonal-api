package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDiceWords;

import java.util.Optional;

public class ForGettingEmptyDiceWords implements ForGettingDiceWords {

    @Override
    public Optional<DiceWord> findById (String id) {

        return Optional.empty();

    }

}
