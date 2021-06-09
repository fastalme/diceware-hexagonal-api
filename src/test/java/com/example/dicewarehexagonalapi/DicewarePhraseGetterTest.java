package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.ports.ForGettingDicewarePhrase;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDiceWords;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;
import com.example.dicewarehexagonalapi.app.DicewarePhraseGetter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DicewarePhraseGetterTest {

    private ForGettingDiceWords forGettingDiceWords;
    private ForGettingWordSynonyms forGettingWordSynonyms;

    private ForGettingDicewarePhrase forGettingDicewarePhrase;

    @BeforeEach
    void init () {
        forGettingDiceWords = mock (ForGettingDiceWords.class);
        forGettingWordSynonyms = mock (ForGettingWordSynonyms.class);
        forGettingDicewarePhrase = new DicewarePhraseGetter (forGettingDiceWords, forGettingWordSynonyms);
    }

    @Test
    void shouldReturnDicewarePhrase () {

        when (forGettingDiceWords.findById (anyString ())).thenReturn (DiceWordFactory.createRandom());
        when (forGettingWordSynonyms.findSynonymsByWord (anyString ())).thenReturn (SynonymsResultFactory.createTwoElementsResult ());

        String dicewarePhrase = forGettingDicewarePhrase.get (2);

        assertNotNull(dicewarePhrase);

    }

}
