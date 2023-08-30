package com.example.dicewarehexagonalapi.infra;

import com.example.dicewarehexagonalapi.app.DicewarePhraseGetter;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDiceWords;
import com.example.dicewarehexagonalapi.app.ports.ForGettingDicewarePhrase;
import com.example.dicewarehexagonalapi.app.ports.ForGettingWordSynonyms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example")
public class DicewareHexagonalApiApplication {

    public static void main (String[] args) {
        SpringApplication.run(DicewareHexagonalApiApplication.class, args);
    }

    @Bean
    public ForGettingDicewarePhrase forGettingDicewarePhrase (ForGettingDiceWords forGettingDiceWords,
                                                              ForGettingWordSynonyms forGettingWordSynonyms) {
        return new DicewarePhraseGetter(forGettingDiceWords, forGettingWordSynonyms);
    }

}
