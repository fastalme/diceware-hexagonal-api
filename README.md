# Diceware Hexagonal API
Is a project whose main goal is to be used as an example of how a traditional layered service could be refactored to an hexagonal architecture (at package level).

## Main concepts
* Diceware™ is a method for picking passphrases that uses ordinary dice to select words at random from a special list called the Diceware Word List. [More information](https://theworld.com/~reinhold/diceware.html)
* Words API lets you retrieve information about English words, including definitions, synonyms, rhymes, pronunciation, syllables, and frequency of usage.  [More information](https://rapidapi.com/dpventures/api/wordsapi/)

## How to read this example
There are two branches in this repository:
* `main` branch: It has the original API version, which implements a classic layered architecture. 
* `hexagonal` branch: It has the refactored API version, which implements a new package organization and a hexagonal architecture.
 
## How to run

### Pre requisites
* Java Development Kit 11 or later
* Maven 3.6 or later

### Without the synonyms feature
* Run `mvn spring-boot:run`
* In a new terminal run `curl 'http://localhost:8080/diceware-phrase?word-count=5'`

### With the synonyms feature
* Create a free WordsAPI token through [RapidAPI](https://rapidapi.com/dpventures/api/wordsapi/pricing)
* Save this token as an environment variable with the name `WORDSAPI_KEY`
* Run `mvn spring-boot:run`
* In a new terminal run `curl 'http://localhost:8080/diceware-phrase-synonyms?word-count=5'`