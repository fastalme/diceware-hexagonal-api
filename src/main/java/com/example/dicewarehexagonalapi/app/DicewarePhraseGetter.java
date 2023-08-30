package com.example.dicewarehexagonalapi.app;

import com.example.dicewarehexagonalapi.app.entity.DiceWord;
import com.example.dicewarehexagonalapi.app.entity.SynonymList;
import com.example.dicewarehexagonalapi.app.exception.InvalidWordCountException;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDiceWords;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDicewarePhrase;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class DicewarePhraseGetter implements ForGettingDicewarePhrase {

    public static final String DEFAULT_WORD = "none";
    public static final int MIN_WORD_COUNT = 2;
    public static final int MAX_WORD_COUNT = 8;
    private static final Logger LOG = LoggerFactory.getLogger(DicewarePhraseGetter.class);
    private final ForGettingDiceWords forGettingDiceWords;
    private final ForGettingWordSynonyms forGettingWordSynonyms;

    public DicewarePhraseGetter (ForGettingDiceWords forGettingDiceWords,
                                 ForGettingWordSynonyms forGettingWordSynonyms) {
        this.forGettingDiceWords = forGettingDiceWords;
        this.forGettingWordSynonyms = forGettingWordSynonyms;
    }

    @Override
    public String get (int wordCount) {

        if (wordCount < MIN_WORD_COUNT || wordCount > MAX_WORD_COUNT) {
            throw new InvalidWordCountException();
        }

        var phrase = new StringBuilder();
        for (var i = 0; i < wordCount; i++) {
            phrase.append(findRandomWord()).append(" ");
        }

        return phrase.toString().trim();

    }

    @Override
    public List<String> getWithSynonyms (int wordCount) {
        if (wordCount < MIN_WORD_COUNT || wordCount > MAX_WORD_COUNT) {
            throw new InvalidWordCountException();
        }

        var phrase = new StringBuilder();
        var synonymsPhrase = new StringBuilder();
        String randomWord;
        for (var i = 0; i < wordCount; i++) {
            randomWord = findRandomWord();
            phrase.append(randomWord).append(" ");
            synonymsPhrase.append(findRandomSynonym(randomWord)).append(" ");
        }

        return Arrays.asList(phrase.toString().trim(), synonymsPhrase.toString().trim());
    }

    private String findRandomSynonym (String word) {
        SynonymList synonymList;
        try {
            synonymList = forGettingWordSynonyms.findSynonymsByWord(word);
        } catch (Exception e) {
            LOG.warn("WordsAPI exception", e);
            return word;
        }
        if (synonymList.getSynonyms().isEmpty()) {
            return word;
        }
        return synonymList.getSynonyms()
                .get(ThreadLocalRandom.current().nextInt(synonymList.getSynonyms().size()));
    }

    private String findRandomWord () {
        Optional<DiceWord> diceWord = this.forGettingDiceWords.findById(calculateId());
        return diceWord.isPresent() ? diceWord.get().getWord() : DEFAULT_WORD;
    }

    private String calculateId () {

        int id =
                diceRoll() +
                        diceRoll() * 10 +
                        diceRoll() * 100 +
                        diceRoll() * 1000 +
                        diceRoll() * 10000;

        return String.valueOf(id);
    }

    private int diceRoll () {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

}
