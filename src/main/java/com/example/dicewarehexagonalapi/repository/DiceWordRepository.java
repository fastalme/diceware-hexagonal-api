package com.example.dicewarehexagonalapi.repository;

import com.example.dicewarehexagonalapi.entity.DiceWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceWordRepository extends CrudRepository<DiceWord, String> {
}
