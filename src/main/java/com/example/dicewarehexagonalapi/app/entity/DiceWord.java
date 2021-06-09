package com.example.dicewarehexagonalapi.app.entity;

public class DiceWord {

    private String id;
    private String word;

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
