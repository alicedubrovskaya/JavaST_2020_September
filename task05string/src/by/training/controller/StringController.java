package by.training.controller;

import by.training.serviсe.ServiceFactory;
import by.training.serviсe.StringService;

public class StringController {
    private StringService stringService;

    public StringController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.stringService = serviceFactory.getStringService();
    }

    public char[][] replaceNeededLettersWithAGivenCharacter(char character, int k, char[][] words) {
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

    public char[][] fixIncorrectLetters(char preceding, char incorrect, char needed, char[][] words) {
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

    public char[][] replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, char[] wordToWrite, char[][] words) {
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

    public char[][] parseStringToArrayOfWords(char[] string) {
        char[] stringWithoutExtraCharacters = stringService.removeExtraCharacters(string);
        return stringService.parseStringToArrayOfWords(stringWithoutExtraCharacters);
    }
}
