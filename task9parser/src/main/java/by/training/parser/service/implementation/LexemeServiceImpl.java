package by.training.parser.service.implementation;

import by.training.parser.entity.Component;
import by.training.parser.service.LexemeService;

public class LexemeServiceImpl implements LexemeService {

    public long numberOfSymbolOccurrences(Component lexeme, char symbol) {
        String string = lexeme.recoverText();
        return string.chars().filter(character -> character == symbol).count();
    }
}
