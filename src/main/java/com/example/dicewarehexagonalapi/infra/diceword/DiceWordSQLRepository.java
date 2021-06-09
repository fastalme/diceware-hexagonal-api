package com.example.dicewarehexagonalapi.infra.diceword;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;
import com.example.dicewarehexagonalapi.app.repository.DiceWordRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DiceWordSQLRepository implements DiceWordRepository {

    private final DiceWordCrudRepository diceWordCrudRepository;

    public DiceWordSQLRepository (DiceWordCrudRepository diceWordCrudRepository) {
        this.diceWordCrudRepository = diceWordCrudRepository;
    }

    @Override
    public Optional<DiceWord> findById (String id) {
        return this.diceWordCrudRepository.findById (id).map (DiceWordSQLEntity::toDiceWord);
    }
}
