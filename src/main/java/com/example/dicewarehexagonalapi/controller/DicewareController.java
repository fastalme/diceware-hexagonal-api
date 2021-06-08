package com.example.dicewarehexagonalapi.controller;

import com.example.dicewarehexagonalapi.service.DicewareService;
import com.example.dicewarehexagonalapi.util.dto.DicewareDTO;
import com.example.dicewarehexagonalapi.util.dto.DicewareWithSynonymsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DicewareController {

    private final DicewareService dicewareService;

    public DicewareController (DicewareService dicewareService) {
        this.dicewareService = dicewareService;
    }

    @GetMapping ("/diceware-phrase")
    public DicewareDTO getDicewarePhrase (@RequestParam (name = "word-count") int wordCount) {
        return new DicewareDTO (dicewareService.getDicewarePhrase (wordCount));
    }

    @GetMapping ("/diceware-phrase-synonyms")
    public DicewareWithSynonymsDTO getDicewarePhraseWithSynonyms (@RequestParam (name = "word-count") int wordCount) {
        List<String> phrases = dicewareService.getDicewarePhraseWithSynonyms (wordCount);
        return new DicewareWithSynonymsDTO (phrases.get (0), phrases.get (1));
    }

}
