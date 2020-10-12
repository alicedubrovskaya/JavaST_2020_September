package by.training.controller;

import by.training.serviсe.ParserService;
import by.training.serviсe.StringService;
import by.training.serviсe.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class StringController {
    private ParserService parserService;
    private StringService stringService;

    public StringController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.parserService = serviceFactory.getParserService();
        this.stringService = serviceFactory.getStringService();
    }

    public List<StringBuilder> parseStringToListOfWords(String string) {
        StringBuilder stringWithoutExtraCharacters = parserService.removeExtraCharacters(string);
        List<StringBuilder> result = parserService.parseStringToWords(stringWithoutExtraCharacters);
        return result;
    }

    public List<StringBuilder> replaceNeededLettersWithAGivenCharacter(char character, int k) {
        List<StringBuilder> result = new ArrayList<>();

        for (StringBuilder word : stringService.getWords()) {
            result.add(stringService.replaceLetterWithAGivenCharacter(character, k, word));
        }
        return result;
    }

}
