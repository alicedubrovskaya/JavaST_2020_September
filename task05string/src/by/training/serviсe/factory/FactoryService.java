package by.training.serviсe.factory;

import by.training.serviсe.CharWordService;
import by.training.serviсe.MemoryStringService;
import by.training.serviсe.ParserService;
import by.training.serviсe.StringWordService;
import by.training.serviсe.implementation.CharWordServiceImpl;
import by.training.serviсe.implementation.MemoryStringServiceImpl;
import by.training.serviсe.implementation.ParserServiceImpl;
import by.training.serviсe.implementation.StringWordServiceImpl;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private final StringWordFactory stringWordFactory = new StringWordFactory();

    private final CharWordService charWordService = new CharWordServiceImpl();
    private final MemoryStringService memoryStringService = new MemoryStringServiceImpl();
    private final ParserService parserService = new ParserServiceImpl(charWordService);

    public FactoryService() {
    }

    public static FactoryService getInstance() {
        return instance;
    }

    public StringWordService getStringWordService(String type) {
        return stringWordFactory.getWordService(type);
    }

    public CharWordService getCharWordService() {
        return charWordService;
    }

    public ParserService getParserService() {
        return parserService;
    }

    public MemoryStringService getMemoryStringService() {
        return memoryStringService;
    }
}
