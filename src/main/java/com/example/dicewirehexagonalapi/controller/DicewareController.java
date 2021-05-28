package com.example.dicewirehexagonalapi.controller;

import com.example.dicewirehexagonalapi.DicewareDTO;
import com.example.dicewirehexagonalapi.service.DicewareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DicewareController {

    private final DicewareService dicewareService;

    public DicewareController (DicewareService dicewareService) {
        this.dicewareService = dicewareService;
    }

    @GetMapping("/diceware-phrase")
    public DicewareDTO getDicewarePhrase(@RequestParam(name = "dice-rolls") int diceRolls) {
        return new DicewareDTO (dicewareService.getDicewarePhrase (diceRolls));
    }

}
