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
            }
        }
        return result;
    }

    public char[][] fixIncorrectLetters(char preceding, char incorrect, char needed, char[][] words) {
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = stringService.changeIncorrectCharacters(preceding, incorrect, needed, words[i]);
            }
        }
        return result;
    }

    public char[][] parseStringToArrayOfWords(char[] string) {
        return stringService.parseStringToArrayOfWords(string);
    }
}
