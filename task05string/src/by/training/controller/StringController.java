package by.training.controller;

import by.training.serviсe.ParserService;
import by.training.serviсe.ServiceFactory;

import java.util.List;

public class StringController {
    private ParserService parserService;

    public StringController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.parserService = serviceFactory.getParserService();
    }

    public List<StringBuilder> parseStringToListOfWords(String string) {
        StringBuilder stringWithoutExtraCharacters = parserService.removeExtraCharacters(string);
        List<StringBuilder> result= parserService.parseStringToWords(stringWithoutExtraCharacters);
        return result;
    }

}
