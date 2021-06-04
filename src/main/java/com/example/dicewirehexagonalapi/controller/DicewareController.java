package com.example.dicewirehexagonalapi.controller;

import com.example.dicewirehexagonalapi.service.DicewareService;
import com.example.dicewirehexagonalapi.util.dto.DicewareDTO;
import com.example.dicewirehexagonalapi.util.dto.DicewareWithSynonymsDTO;
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
    public DicewareDTO getDicewarePhrase (@RequestParam (name = "dice-rolls") int diceRolls) {
        return new DicewareDTO (dicewareService.getDicewarePhrase (diceRolls));
    }

    @GetMapping ("/diceware-phrase-synonyms")
    public DicewareWithSynonymsDTO getDicewarePhraseWithSynonyms (@RequestParam (name = "dice-rolls") int diceRolls) {
        List<String> phrases = dicewareService.getDicewarePhraseWithSynonyms (diceRolls);
        return new DicewareWithSynonymsDTO (phrases.get (0), phrases.get (1));
    }

}
