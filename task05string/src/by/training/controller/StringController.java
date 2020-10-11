package by.training.controller;

import by.training.serviсe.ServiceFactory;
import by.training.serviсe.StringService;

import java.io.IOException;

public class StringController {
    private StringService stringService;

    public StringController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.stringService = serviceFactory.getStringService();
    }

    public void saveText(char[] string) {
        stringService.saveText(parseStringToArrayOfWords(string));
    }

    public void saveText(String fileName) {
        try {
            char[][] words = parseStringToArrayOfWords(stringService.getFromFile(fileName));
            stringService.saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public char[][] replaceNeededLettersWithAGivenCharacter(char character, int k) {
        char[][] words = stringService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = stringService.replaceLetterWithAGivenCharacter(character, k, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] fixIncorrectLetters(char preceding, char incorrect, char needed) {
        char[][] words = stringService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = stringService.changeIncorrectCharacters(preceding, incorrect, needed, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, char[] wordToWrite) {
        char[][] words = stringService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                char[] wordNew = stringService.replaceWordOfSpecifiedLength(lengthOfWordsToReplace, words[i], wordToWrite);
                if (wordNew != null) {
                    result[i] = wordNew;
                } else {
                    result[i] = words[i];
                }
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] wordsWithoutConsonantsAtTheBeginning() {
        char[][] words = stringService.getWords();
        //TODO remove fixed length
        char[][] result = new char[words.length][];
        int currentWordInResult = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                if (!stringService.startsWithConsonant(words[i])) {
                    currentWordInResult++;
                    result[currentWordInResult] = words[i];
                }
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] parseStringToArrayOfWords(char[] string) {
        char[] stringWithoutExtraCharacters = stringService.removeExtraCharacters(string);
        return stringService.parseStringToArrayOfWords(stringWithoutExtraCharacters);
    }
}
