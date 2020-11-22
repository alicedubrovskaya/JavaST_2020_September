package by.training.parser.service;

import by.training.parser.entity.Component;

/**
 * Interface for work with lexemes
 */
public interface LexemeService {
    long numberOfSymbolOccurrences(Component lexeme, char symbol);
}
