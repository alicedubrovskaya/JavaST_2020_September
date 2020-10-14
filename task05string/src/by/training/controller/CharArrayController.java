package by.training.controller;

import by.training.serviсe.CharWordService;
import by.training.serviсe.MemoryCharService;
import by.training.serviсe.factory.FactoryService;

import java.io.IOException;

public class CharArrayController {
    private CharWordService wordService;
    private MemoryCharService memoryService;

    public CharArrayController() {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getCharWordService();
        this.memoryService = factoryService.getMemoryCharService();
    }

    public void saveText(String string) {
        memoryService.saveText(parseStringToArrayOfWords(string));
    }

    public void saveFromFile(String fileName) {
        try {
            String words = memoryService.getFromFile(fileName);
            saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public char[][] parseStringToArrayOfWords(String string) {
        char[] stringWithoutExtraCharacters = wordService.removeExtraCharacters(string.toCharArray());
        return wordService.parseStringToWords(stringWithoutExtraCharacters);
    }
}
