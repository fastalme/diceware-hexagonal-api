package com.example.dicewarehexagonalapi.infra.wordsapi;

import com.example.dicewarehexagonalapi.app.entity.WordSynonyms;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;
import org.springframework.stereotype.Component;

@Component
public class ForGettingAPIWordSynonyms implements ForGettingWordSynonyms {

    private final WordsAPIClient wordsAPIClient;

    public ForGettingAPIWordSynonyms (WordsAPIClient wordsAPIClient) {
        this.wordsAPIClient = wordsAPIClient;
    }

    @Override
    public WordSynonyms findSynonymsByWord (String word) {
        return this.wordsAPIClient.getSynonyms (word);
    }

}
