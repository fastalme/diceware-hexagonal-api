package com.example.dicewarehexagonalapi.service;

import com.example.dicewarehexagonalapi.entity.DiceWord;
import com.example.dicewarehexagonalapi.externalapis.SynonymsResult;
import com.example.dicewarehexagonalapi.externalapis.WordsAPIClient;
import com.example.dicewarehexagonalapi.repository.DiceWordRepository;
import com.example.dicewarehexagonalapi.util.exception.DicerollsInvalidValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DicewareService {

    public static final String DEFAULT_WORD = "none";
    public static final int MIN_WORD_INDEX = 1;
    public static final int MAX_WORD_INDEX = 6;
    public static final int MIN_DICE_ROLLS = 2;
    public static final int MAX_DICE_ROLLS = 8;
    private static final Logger LOG = LoggerFactory.getLogger (DicewareService.class);
    private final DiceWordRepository diceWordRepository;
    private final WordsAPIClient wordsAPIClient;

    public DicewareService (DiceWordRepository diceWordRepository,
                            WordsAPIClient wordsAPIClient) {
        this.diceWordRepository = diceWordRepository;
        this.wordsAPIClient = wordsAPIClient;
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

    public List<String> getDicewarePhraseWithSynonyms (int diceRolls) {

        if (diceRolls < MIN_DICE_ROLLS || diceRolls > MAX_DICE_ROLLS) {
            throw new DicerollsInvalidValue ();
        }

        var phrase = new StringBuilder ();
        var synonymsPhrase = new StringBuilder ();
        String randomWord;
        for (var i = 0; i < diceRolls; i++) {
            randomWord = findRandomWord ();
            phrase.append (randomWord).append (" ");
            synonymsPhrase.append (findRandomSynonym (randomWord)).append (" ");
        }

        return Arrays.asList (phrase.toString ().trim (), synonymsPhrase.toString ().trim ());
    }

    private String findRandomSynonym (String word) {
        SynonymsResult synonymsResult;
        try {
            synonymsResult = wordsAPIClient.getSynonyms (word);
        } catch (Exception e) {
            LOG.warn ("WordsAPI exception", e);
            return word;
        }
        if (synonymsResult.getSynonyms ().isEmpty ()) {
            return word;
        }
        return synonymsResult.getSynonyms ()
                .get (ThreadLocalRandom.current ().nextInt (synonymsResult.getSynonyms ().size ()));
    }

    private String findRandomWord () {
        Optional<DiceWord> diceWord = this.diceWordRepository.findById (calculateId ());
        return diceWord.isPresent () ? diceWord.get ().getWord () : DEFAULT_WORD;
    }

    private String calculateId () {

        int id =
                ThreadLocalRandom.current ().nextInt (MIN_WORD_INDEX, MAX_WORD_INDEX + 1) +
                        ThreadLocalRandom.current ().nextInt (MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 10 +
                        ThreadLocalRandom.current ().nextInt (MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 100 +
                        ThreadLocalRandom.current ().nextInt (MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 1000 +
                        ThreadLocalRandom.current ().nextInt (MIN_WORD_INDEX, MAX_WORD_INDEX + 1) * 10000;

        return String.valueOf (id);
    }

}
