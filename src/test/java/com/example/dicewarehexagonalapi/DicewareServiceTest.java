package com.example.dicewarehexagonalapi;

import com.example.dicewarehexagonalapi.externalapis.WordsAPIClient;
import com.example.dicewarehexagonalapi.repository.DiceWordRepository;
import com.example.dicewarehexagonalapi.service.DicewareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DicewareServiceTest {

    private DiceWordRepository diceWordRepository;
    private WordsAPIClient wordsAPIClient;

    private DicewareService dicewareService;

    @BeforeEach
    void init () {
        diceWordRepository = mock (DiceWordRepository.class);
        wordsAPIClient = mock (WordsAPIClient.class);
        dicewareService = new DicewareService (diceWordRepository, wordsAPIClient);
    }

    @Test
    void shouldReturnDicewarePhrase () {

        when (diceWordRepository.findById (anyString ())).thenReturn (DiceWordFactory.createRandom());
        when (wordsAPIClient.getSynonyms (anyString ())).thenReturn (SynonymsResultFactory.createTwoElementsResult ());

        String dicewarePhrase = dicewareService.getDicewarePhrase (2);

        assertNotNull(dicewarePhrase);

    }

}
