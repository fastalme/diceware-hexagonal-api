package com.example.dicewarehexagonalapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "dice_word")
public class DiceWord {

    @Id
    private String id;
    private String word;

    public DiceWord () {
    }

    public DiceWord (String id, String word) {
        this.id = id;
        this.word = word;
    }

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
}
