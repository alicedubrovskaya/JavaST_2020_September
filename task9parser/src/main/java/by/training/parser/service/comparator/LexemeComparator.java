package by.training.parser.service.comparator;

import by.training.parser.entity.Component;
import by.training.parser.service.LexemeService;
import by.training.parser.service.ServiceFactory;

import java.util.Comparator;

public class LexemeComparator implements Comparator<Component> {
    private char symbol;
    private LexemeService lexemeService;

    public LexemeComparator(char symbol) {
        this.symbol = symbol;
        ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
        this.lexemeService = serviceFactory.getLexemeService();
    }

    @Override
    public int compare(Component lexeme, Component lexeme1) {
        return Long.compare(lexemeService.numberOfSymbolOccurrences(lexeme, symbol), lexemeService.
                numberOfSymbolOccurrences(lexeme1, symbol));
    }
}
