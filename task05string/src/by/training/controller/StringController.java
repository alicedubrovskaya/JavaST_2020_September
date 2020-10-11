package by.training.controller;

import by.training.serviсe.ServiceFactory;
import by.training.serviсe.StringService;

public class StringController {
    private StringService stringService;

    public StringController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.stringService = serviceFactory.getStringService();
    }

    public char[] replaceNeededLettersWithAGivenCharacter(char character, int k, char[] string) {
        return stringService.replaceLetterWithAGivenCharacter(character, k, string);
    }

    public char[] fixIncorrectLetters(char preceding, char incorrect, char needed, char[] string){
        return stringService.changeIncorrectCharacters(preceding,incorrect,needed,string);
    }

    public char[][] parseStringToArrayOfWords(char[] string){
        return stringService.parseStringToArrayOfWords(string);
    }
}
