package com.example.dicewarehexagonalapi.app.repository;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;

import java.util.Optional;

public interface DiceWordRepository {

    Optional<DiceWord> findById (String id);

}
