package com.example.dicewarehexagonalapi.infra.wordsapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "wordsapi", url = "https://${wordsapi.host}")
public interface WordsAPIClient {

    @GetMapping(value = "/words/{word}/synonyms")
    WordsAPISynonyms getSynonyms (@PathVariable String word);

}
