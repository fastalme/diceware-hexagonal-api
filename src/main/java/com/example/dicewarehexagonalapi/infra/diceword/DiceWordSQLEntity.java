package com.example.dicewarehexagonalapi.infra.diceword;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dice_word")
public class DiceWordSQLEntity {

    @Id
    private String id;
    private String word;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getWord () {
        return word;
    }

    public void setWord (String word) {
        this.word = word;
    }

    public DiceWord toDiceWord () {
        return new DiceWord(this.id, this.word);
    }

}
