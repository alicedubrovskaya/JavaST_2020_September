package by.training.controller;

import by.training.serviсe.MemoryStringService;
import by.training.serviсe.StringWordService;
import by.training.serviсe.factory.FactoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class is a controller of class Text. Works with words, witch type is String
 *
 * @author Alisa Dubrovskaya
 */
public class StringController {
    private StringWordService wordService;
    private MemoryStringService memoryService;

    public StringController(String typeOfServiceImplementation) {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getStringWordService(typeOfServiceImplementation);
        this.memoryService = factoryService.getMemoryStringService();
    }

    /**
     * Saves words to text
     *
     * @param string
     */
    public void saveText(String string) {
        memoryService.saveText(parseStringToArrayOfWords(string));
    }

    /**
     * Saves words from file to text
     *
     * @param fileName
     */
    public void saveFromFile(String fileName) {
        try {
            String words = memoryService.getFromFile(fileName);
            saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Replaces character in specified sequences with needed character
     *
     * @param character
     * @param k
     * @return
     */
    public List<StringBuilder> replaceNeededLettersWithAGivenCharacter(char character, int k) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : memoryService.getWords()) {
            result.add(wordService.replaceLetterWithAGivenCharacter(character, k, word));
        }
        return result;
    }

    /**
     * Replaces word with another word if it's length corresponds to needed length
     *
     * @param preceding
     * @param incorrect
     * @param needed
     * @return
     */
    public List<StringBuilder> fixIncorrectLetters(char preceding, char incorrect, char needed) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : memoryService.getWords()) {
            result.add(wordService.changeIncorrectCharacters(preceding, incorrect, needed, word));
        }
        return result;
    }

    /**
     * Replaces word with another word if it's length corresponds to needed length
     *
     * @param lengthOfWordsToReplace
     * @param wordToWrite
     * @return
     */
    public List<StringBuilder> replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, String wordToWrite) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : memoryService.getWords()) {
            result.add(wordService.replaceWordOfSpecifiedLength
                    (lengthOfWordsToReplace, word, new StringBuilder(wordToWrite)));
        }
        return result;
    }

    /**
     * Finds words starting with consonant
     *
     * @return
     */
    public List<StringBuilder> wordsWithoutConsonantsAtTheBeginning() {
        List<StringBuilder> result = new ArrayList<>();
        for (StringBuilder word : memoryService.getWords()) {
            if (!wordService.startsWithConsonant(word)) {
                result.add(word);
            }
        }
        return result;
    }

    /**
     * Parsers string to words
     *
     * @param string
     * @return
     */
    public List<StringBuilder> parseStringToArrayOfWords(String string) {
        StringBuilder stringWithoutExtraCharacters = wordService.removeExtraCharacters(new StringBuilder(string));
        return wordService.parseStringToWords(stringWithoutExtraCharacters);
    }
}
