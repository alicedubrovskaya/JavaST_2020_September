package by.training.controller;

import by.training.serviсe.CharWordService;
import by.training.serviсe.MemoryCharService;
import by.training.serviсe.factory.FactoryService;

import java.io.IOException;


/**
 * Class is a controller of class Text. Works with words, witch type is char[]
 *
 * @author Alisa Dubrovskaya
 */
public class CharArrayController {
    private CharWordService wordService;
    private MemoryCharService memoryService;

    public CharArrayController() {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getCharWordService();
        this.memoryService = factoryService.getMemoryCharService();
    }

    /**
     * Saves words to text
     * @param string
     */
    public void saveText(String string) {
        memoryService.saveText(parseStringToArrayOfWords(string));
    }

    /**
     * Saves words from file to text
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
     * Replaces specified letters of word with specified character
     * @param character
     * @param k
     * @return
     */
    public char[][] replaceNeededLettersWithAGivenCharacter(char character, int k) {
        char[][] words = memoryService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = wordService.replaceLetterWithAGivenCharacter(character, k, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Replaces character in specified sequences with needed character
     * @param preceding
     * @param incorrect
     * @param needed
     * @return
     */
    public char[][] fixIncorrectLetters(char preceding, char incorrect, char needed) {
        char[][] words = memoryService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = wordService.changeIncorrectCharacters(preceding, incorrect, needed, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Replaces word with another word if it's length corresponds to needed length
     * @param lengthOfWordsToReplace
     * @param wordToWrite
     * @return
     */
    public char[][] replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, char[] wordToWrite) {
        char[][] words = memoryService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = wordService.replaceWordOfSpecifiedLength(lengthOfWordsToReplace, words[i], wordToWrite);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Checks if specified word starts with consonant or not
     * @return
     */
    public char[][] wordsWithoutConsonantsAtTheBeginning() {
        char[][] words = memoryService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                if (!wordService.startsWithConsonant(words[i])) {
                    result[i] = words[i];
                }
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Parsers string to words
     * @param string
     * @return array of words
     */
    public char[][] parseStringToArrayOfWords(String string) {
        char[] stringWithoutExtraCharacters = wordService.removeExtraCharacters(string.toCharArray());
        return wordService.parseStringToWords(stringWithoutExtraCharacters);
    }
}
