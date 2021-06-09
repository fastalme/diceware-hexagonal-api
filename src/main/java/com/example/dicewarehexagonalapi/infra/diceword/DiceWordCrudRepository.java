package com.example.dicewarehexagonalapi.infra.diceword;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceWordCrudRepository extends CrudRepository<DiceWordSQLEntity, String> {
}
