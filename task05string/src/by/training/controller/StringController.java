package by.training.controller;

import by.training.serviсe.MemoryStringService;
import by.training.serviсe.ParserService;
import by.training.serviсe.StringWordService;
import by.training.serviсe.factory.FactoryService;
import by.training.serviсe.implementation.RegexParserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringController {
    private StringWordService wordService;
    private ParserService parserService;
    private MemoryStringService memoryStringService;

    public StringController() {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getStringWordService("REGEX");
        this.parserService = new RegexParserServiceImpl();
        this.memoryStringService = factoryService.getMemoryStringService();
    }

    public void saveText(String string) {
        memoryStringService.saveText(parseStringToArrayOfWords(string));
    }

    public void saveFromFile(String fileName) {
        try {
            String words = memoryStringService.getFromFile(fileName);
            saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<StringBuilder> replaceNeededLettersWithAGivenCharacter(char character, int k) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : memoryStringService.getWords()) {
            result.add(wordService.replaceLetterWithAGivenCharacter(character, k, word));
        }
        return result;
    }

    public List<StringBuilder> fixIncorrectLetters(char preceding, char incorrect, char needed) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : memoryStringService.getWords()) {
            result.add(wordService.changeIncorrectCharacters(preceding, incorrect, needed, word));
        }
        return result;
    }

    public List<StringBuilder> replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, String wordToWrite) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : memoryStringService.getWords()) {
            result.add(wordService.replaceWordOfSpecifiedLength
                    (lengthOfWordsToReplace, word, new StringBuilder(wordToWrite)));
        }
        return result;
    }

    public List<StringBuilder> wordsWithoutConsonantsAtTheBeginning() {
        List<StringBuilder> result = new ArrayList<>();
        for (StringBuilder word : memoryStringService.getWords()) {
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
