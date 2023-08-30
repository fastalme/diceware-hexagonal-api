package com.example.dicewarehexagonalapi.infra.wordsapi;

import com.example.dicewarehexagonalapi.app.entity.SynonymList;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;
import org.springframework.stereotype.Component;

@Component
public class ForGettingAPIWordSynonyms implements ForGettingWordSynonyms {

    private final WordsAPIClient wordsAPIClient;

    public ForGettingAPIWordSynonyms (WordsAPIClient wordsAPIClient) {
        this.wordsAPIClient = wordsAPIClient;
    }

    @Override
    public SynonymList findSynonymsByWord (String word) {
        return new SynonymList(this.wordsAPIClient.getSynonyms(word).getSynonyms());
    }

}
