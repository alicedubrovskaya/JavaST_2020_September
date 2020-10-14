package by.training.controller;

import by.training.serviсe.MemoryService;
import by.training.serviсe.StringWordService;
import by.training.serviсe.factory.FactoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is a controller of class Text. Works with words, witch type is String
 *
 * @author Alisa Dubrovskaya
 */
public class StringController {
    private StringWordService wordService;
    private MemoryService memoryService;

    public StringController(String typeOfServiceImplementation) {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getStringWordService(typeOfServiceImplementation);
        this.memoryService = factoryService.getMemoryService();
    }

    /**
     * Saves words to text
     *
     * @param string
     */
    public void saveText(List<String> string) {
        memoryService.saveText(string);
    }

    /**
     * Saves words from file to text
     *
     * @param fileName
     */
 /*   public void saveFromFile(String fileName) {
        try {
            String words = memoryService.getFromFile(fileName);
            saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


  */

    /**
     * Replaces character in specified sequences with needed character
     *
     * @param character
     * @param k
     * @return
     */
    public List<String> replaceNeededLettersWithAGivenCharacter(char character, int k) {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            String string = new String();

            for (StringBuilder word : parseStringToArrayOfWords(line)) {
                string += wordService.replaceLetterWithAGivenCharacter(character, k, word) + " ";
            }
            resultingLines.add(string);
        }
        return resultingLines;
    }


    /**
     * Replaces word with another word if it's length corresponds to needed length
     *
     * @param preceding
     * @param incorrect
     * @param needed
     * @return
     */
    public List<String> fixIncorrectLetters(char preceding, char incorrect, char needed) {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            String string = new String();

            for (StringBuilder word : parseStringToArrayOfWords(line)) {
                string +=wordService.changeIncorrectCharacters(preceding, incorrect, needed, word) + " ";
            }
            resultingLines.add(string);
        }
        return resultingLines;
    }

    /**
     * Replaces word with another word if it's length corresponds to needed length
     *
     * @param lengthOfWordsToReplace
     * @param wordToWrite
     * @return
     */
    public List<String> replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, String wordToWrite) {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            String string = new String();

            for (StringBuilder word : parseStringToArrayOfWords(line)) {
                string +=wordService.replaceWordOfSpecifiedLength
                        (lengthOfWordsToReplace, word, new StringBuilder(wordToWrite)) + " ";
            }
            resultingLines.add(string);
        }
        return resultingLines;
    }

    /**
     * Finds words starting with consonant
     *
     * @return
     */
    public List<String> wordsWithoutConsonantsAtTheBeginning() {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            String string = new String();

            for (StringBuilder word : parseStringToArrayOfWords(line)) {
                if (!wordService.startsWithConsonant(word)) {
                    string=word+" ";
                }
            }
            resultingLines.add(string);
        }
        return resultingLines;
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
