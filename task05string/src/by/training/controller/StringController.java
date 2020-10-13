package by.training.controller;

import by.training.serviсe.StringParserService;
import by.training.serviсe.StringWordService;
import by.training.serviсe.factory.FactoryService;

import java.util.ArrayList;
import java.util.List;

public class StringController {
    private StringWordService wordService;
    private StringParserService parserService;

    public StringController() {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getStringWordService();
        this.parserService = factoryService.getStringParserService();
    }

    public void saveText(String string) {
        wordService.saveText(parseStringToArrayOfWords(string));
    }

    public List<StringBuilder> replaceNeededLettersWithAGivenCharacter(char character, int k) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : wordService.getWords()) {
            result.add( wordService.replaceLetterWithAGivenCharacter(character, k, word));
        }
        return result;
    }

    public List<StringBuilder> fixIncorrectLetters(char preceding, char incorrect, char needed) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : wordService.getWords()) {
            result.add(wordService.changeIncorrectCharacters(preceding, incorrect, needed, word));
        }
        return result;
    }

    public List<StringBuilder> replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, String wordToWrite) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : wordService.getWords()) {
            result.add(wordService.replaceWordOfSpecifiedLength
                    (lengthOfWordsToReplace, word, new StringBuilder(wordToWrite)));
        }
        return result;
    }

    public List<StringBuilder> wordsWithoutConsonantsAtTheBeginning() {
        List<StringBuilder> result = new ArrayList<>();
        for (StringBuilder word : wordService.getWords()) {
            if (!wordService.startsWithConsonant(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public List<StringBuilder> parseStringToArrayOfWords(String string) {
        StringBuilder stringWithoutExtraCharacters = parserService.removeExtraCharacters(new StringBuilder(string));
        return parserService.parseStringToWords(stringWithoutExtraCharacters);
    }
}
