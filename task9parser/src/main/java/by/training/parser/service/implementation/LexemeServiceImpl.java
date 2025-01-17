package by.training.parser.service.implementation;

import by.training.parser.entity.Component;
import by.training.parser.service.LexemeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class is an implementation of interface LexemeService
 */
public class LexemeServiceImpl implements LexemeService {
    private Logger logger = LogManager.getLogger(this.getClass().getName());

    /**
     * Calculates count of specified symbol occurrences in lexeme
     * @param lexeme
     * @param symbol
     * @return
     */
    public long numberOfSymbolOccurrences(Component lexeme, char symbol) {
        logger.info("Calculation of symbol={} occurrences in lexeme", symbol);
        String string = lexeme.recoverText();
        return string.chars().filter(character -> character == symbol).count();
    }
}
