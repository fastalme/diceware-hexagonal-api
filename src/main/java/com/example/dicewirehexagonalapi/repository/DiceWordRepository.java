package com.example.dicewirehexagonalapi.repository;

import com.example.dicewirehexagonalapi.entity.DiceWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceWordRepository extends CrudRepository<DiceWord, String> {
}
