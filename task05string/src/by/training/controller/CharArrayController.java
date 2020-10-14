package by.training.controller;

import by.training.serviсe.CharWordService;
import by.training.serviсe.MemoryService;
import by.training.serviсe.factory.FactoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class is a controller of class Text. Works with words, witch type is char[]
 *
 * @author Alisa Dubrovskaya
 */
public class CharArrayController {
    private CharWordService wordService;
    private MemoryService memoryService;

    public CharArrayController() {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getCharWordService();
        this.memoryService = factoryService.getMemoryService();
    }

    /**
     * Saves lines to text
     *
     * @param lines
     */
    public void saveText(List<String> lines) {
        memoryService.saveText(lines);
    }

    /**
     * Saves lines from file to text
     *
     * @param fileName
     */
    public void saveFromFile(String fileName) {
        try {
            memoryService.saveText(memoryService.getFromFile(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Replaces specified letters of word with specified character
     *
     * @param character
     * @param k
     * @return
     */
    public List<String> replaceNeededLettersWithAGivenCharacter(char character, int k) {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            char[][] words = parseStringToArrayOfWords(line);
            String string = new String();

            for (int i = 0; i < words.length; i++) {
                if (words[i] != null) {
                    string = convert(wordService.replaceLetterWithAGivenCharacter(character, k, words[i])) + " ";
                } else {
                    break;
                }
            }
            resultingLines.add(string);
        }
        return resultingLines;
    }

    /**
     * Replaces character in specified sequences with needed character
     *
     * @param preceding
     * @param incorrect
     * @param needed
     * @return
     */
    public List<String> fixIncorrectLetters(char preceding, char incorrect, char needed) {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            char[][] words = parseStringToArrayOfWords(line);
            String string = new String();

            for (int i = 0; i < words.length; i++) {
                if (words[i] != null) {
                    string = convert(wordService.changeIncorrectCharacters(preceding, incorrect, needed, words[i])) + " ";
                } else {
                    break;
                }
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
    public List<String> replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, char[] wordToWrite) {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            char[][] words = parseStringToArrayOfWords(line);
            String string = new String();

            for (int i = 0; i < words.length; i++) {
                if (words[i] != null) {
                    string = convert(wordService.replaceWordOfSpecifiedLength(lengthOfWordsToReplace, words[i], wordToWrite)) + " ";
                } else {
                    break;
                }
            }
            resultingLines.add(string);
        }
        return resultingLines;
    }

    /**
     * Checks if specified word starts with consonant or not
     *
     * @return
     */
    public List<String> wordsWithoutConsonantsAtTheBeginning() {
        List<String> resultingLines = new ArrayList<>();

        for (String line : memoryService.getLines()) {
            char[][] words = parseStringToArrayOfWords(line);
            String string = new String();

            for (int i = 0; i < words.length; i++) {
                if (words[i] != null) {
                    if (!wordService.startsWithConsonant(words[i])) {
                        string = convert(words[i]) + " ";
                    }
                } else {
                    break;
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
     * @return array of words
     */
    public char[][] parseStringToArrayOfWords(String string) {
        char[] stringWithoutExtraCharacters = wordService.removeExtraCharacters(string.toCharArray());
        return wordService.parseStringToWords(stringWithoutExtraCharacters);
    }

    public String convert(char[] word) {
        String result = "";
        for (int i = 0; i < word.length; i++) {
            result += String.valueOf(word[i]);
        }
        return result;
    }
}
