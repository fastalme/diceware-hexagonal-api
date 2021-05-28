package com.example.dicewirehexagonalapi.externalapis;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient (name = "wordsapi", url = "https://${wordsapi.host}")
public interface WordsAPIClient {

    //@Headers ({"x-rapidapi-host: ${wordsapi.host}", "x-rapidapi-key: ${wordsapi.key}"})
    @RequestMapping (method = RequestMethod.GET, value = "/words/{word}/synonyms")
    SynonymsResult getSynonyms(@PathVariable String word);

}
