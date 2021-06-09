package com.example.dicewarehexagonalapi.app.ports;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;

import java.util.Optional;

public interface ForGettingDiceWords {

    Optional<DiceWord> findById (String id);

}
