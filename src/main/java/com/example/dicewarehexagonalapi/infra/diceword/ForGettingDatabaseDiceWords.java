package com.example.dicewarehexagonalapi.infra.diceword;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDiceWords;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ForGettingDatabaseDiceWords implements ForGettingDiceWords {

    private final DiceWordCrudRepository diceWordCrudRepository;

    public ForGettingDatabaseDiceWords (DiceWordCrudRepository diceWordCrudRepository) {
        this.diceWordCrudRepository = diceWordCrudRepository;
    }

    @Override
    public Optional<DiceWord> findById (String id) {
        return this.diceWordCrudRepository.findById(id).map(DiceWordSQLEntity::toDiceWord);
    }
}
