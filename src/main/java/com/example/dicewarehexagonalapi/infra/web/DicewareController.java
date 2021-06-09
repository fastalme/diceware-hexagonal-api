package com.example.dicewarehexagonalapi.infra.web;

import com.example.dicewarehexagonalapi.app.ports.ForGettingDicewarePhrase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DicewareController {

    private final ForGettingDicewarePhrase forGettingDicewarePhrase;

    public DicewareController (ForGettingDicewarePhrase forGettingDicewarePhrase) {
        this.forGettingDicewarePhrase = forGettingDicewarePhrase;
    }

    @GetMapping ("/diceware-phrase")
    public DicewareDTO getDicewarePhrase (@RequestParam (name = "word-count") int wordCount) {
        return new DicewareDTO (forGettingDicewarePhrase.get (wordCount));
    }

    @GetMapping ("/diceware-phrase-synonyms")
    public DicewareWithSynonymsDTO getDicewarePhraseWithSynonyms (@RequestParam (name = "word-count") int wordCount) {
        List<String> phrases = forGettingDicewarePhrase.getWithSynonyms (wordCount);
        return new DicewareWithSynonymsDTO (phrases.get (0), phrases.get (1));
    }

}
