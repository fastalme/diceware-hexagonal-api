package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.app.DicewarePhraseGetter;
import com.example.dicewarehexagonalapi.app.exception.InvalidWordCountException;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDicewarePhrase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DicewarePhraseGetterTest {

    public static final int ANY_WORD_COUNT = 4;
    public static final int EXPECTED_RESULT_LIST_SIZE = 2;
    private ForGettingDicewarePhrase forGettingDicewarePhrase;

    @Test
    void shouldReturnDicewarePhraseWhenDicewarePhraseIsRequested () {

        forGettingDicewarePhrase =
                new DicewarePhraseGetter(new ForGettingFakeDiceWords(), null);

        String dicewarePhrase = forGettingDicewarePhrase.get(ANY_WORD_COUNT);

        assertNotNull(dicewarePhrase);
        assertEquals(ANY_WORD_COUNT, new StringTokenizer(dicewarePhrase, " ").countTokens());

    }

    @Test
    void shouldReturnDicewarePhraseWithSynonymsWhenDicewarePhraseWithSynonymsIsRequested () {

        forGettingDicewarePhrase =
                new DicewarePhraseGetter(new ForGettingFakeDiceWords(), new ForGettingFakeWordSynonyms());

        List<String> dicewarePhraseWithSynonyms = forGettingDicewarePhrase.getWithSynonyms(ANY_WORD_COUNT);

        assertNotNull(dicewarePhraseWithSynonyms);
        assertEquals(EXPECTED_RESULT_LIST_SIZE, dicewarePhraseWithSynonyms.size());
        assertEquals(ANY_WORD_COUNT, new StringTokenizer(dicewarePhraseWithSynonyms.get(0), " ").countTokens());
        assertEquals(ANY_WORD_COUNT, new StringTokenizer(dicewarePhraseWithSynonyms.get(1), " ").countTokens());

    }

    @Test
    void shouldReturnDefaultDicewarePhraseWhenDicewareRepositoryIsEmpty () {

        forGettingDicewarePhrase =
                new DicewarePhraseGetter(new ForGettingEmptyDiceWords(), null);

        String dicewarePhrase = forGettingDicewarePhrase.get(ANY_WORD_COUNT);

        assertNotNull(dicewarePhrase);
        assertEquals(ANY_WORD_COUNT, new StringTokenizer(dicewarePhrase, " ").countTokens());
        assertEquals(DicewarePhraseGetter.DEFAULT_WORD, new StringTokenizer(dicewarePhrase, " ").nextToken());

    }

    @Test
    void shouldThrowExceptionWhenWordCountIsInvalid () {

        forGettingDicewarePhrase =
                new DicewarePhraseGetter(new ForGettingEmptyDiceWords(), null);

        assertThrows(InvalidWordCountException.class,
                () -> forGettingDicewarePhrase.get(DicewarePhraseGetter.MAX_WORD_COUNT + 1));


    }

}
