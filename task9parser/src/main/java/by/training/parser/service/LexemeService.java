package by.training.parser.service;

import by.training.parser.entity.Component;

public interface LexemeService {
    long numberOfSymbolOccurrences(Component lexeme, char symbol);
}
