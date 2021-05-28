package com.example.dicewirehexagonalapi.service;

import com.example.dicewirehexagonalapi.entity.DiceWord;
import com.example.dicewirehexagonalapi.util.exception.DicerollsInvalidValue;
import com.example.dicewirehexagonalapi.repository.DiceWordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DicewareService {

    public static final String DEFAULT_WORD = "none";
    public static final int MIN_WORD_INDEX = 1;
    public static final int MAX_WORD_INDEX = 6;
    public static final int MIN_DICE_ROLLS = 2;
    public static final int MAX_DICE_ROLLS = 8;
    private final DiceWordRepository diceWordRepository;

    public DicewareService (DiceWordRepository diceWordRepository) {
        this.diceWordRepository = diceWordRepository;
    }

    public String getDicewarePhrase (int diceRolls) {

        if (diceRolls < MIN_DICE_ROLLS || diceRolls > MAX_DICE_ROLLS) {
            throw new DicerollsInvalidValue ();
        }

        var phrase = new StringBuilder ();
        for (var i = 0; i < diceRolls; i++) {
            phrase.append (findRandomWord ()).append (" ");
        }

        return phrase.toString ().trim ();

    }

    private String findRandomWord () {
        Optional<DiceWord> diceWord = this.diceWordRepository.findById (calculateId());
        return diceWord.isPresent () ? diceWord.get ().getWord () : DEFAULT_WORD;
    }

    private String calculateId() {

        int id =
            ThreadLocalRandom.current().nextInt(MIN_WORD_INDEX, MAX_WORD_INDEX + 1) +
                    ThreadLocalRandom.current().nextInt(MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 10 +
                    ThreadLocalRandom.current().nextInt(MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 100 +
                    ThreadLocalRandom.current().nextInt(MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 1000 +
                    ThreadLocalRandom.current().nextInt(MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 10000;

        return String.valueOf (id);
    }

}
