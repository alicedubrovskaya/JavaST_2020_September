package by.training.serviсe.factory;

import by.training.serviсe.CharParserService;
import by.training.serviсe.CharWordService;
import by.training.serviсe.StringParserService;
import by.training.serviсe.StringWordService;
import by.training.serviсe.implementation.CharParserServiceImpl;
import by.training.serviсe.implementation.CharWordServiceImpl;
import by.training.serviсe.implementation.StringParserServiceImpl;
import by.training.serviсe.implementation.StringWordServiceImpl;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class FactoryService {

    private static final FactoryService instance = new FactoryService();
    private final StringWordService stringWordService = new StringWordServiceImpl();
    private final CharWordService charWordService = new CharWordServiceImpl();
    private final StringParserService stringParserService = new StringParserServiceImpl(charWordService);
    private final CharParserService charParserService = new CharParserServiceImpl(charWordService);

    public FactoryService() {
    }

    public static FactoryService getInstance() {
        return instance;
    }

    public StringWordService getStringWordService() {
        return stringWordService;
    }

    public CharWordService getCharWordService() {
        return charWordService;
    }

    public StringParserService getStringParserService() {
        return stringParserService;
    }

    public CharParserService getCharParserService() {
        return charParserService;
    }
}
