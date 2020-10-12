package by.training.serviсe;

import by.training.serviсe.implementation.CharArrayServiceImpl;
import by.training.serviсe.implementation.ParserServiceImpl;
import by.training.serviсe.implementation.StringServiceImpl;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final CharArrayService charArrayService = new CharArrayServiceImpl();
    private final StringService stringService = new StringServiceImpl();
    private final ParserService parserService;

    private ServiceFactory() {
        parserService = new ParserServiceImpl(charArrayService);
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CharArrayService getCharArrayService() {
        return charArrayService;
    }

    public StringService getStringService() {
        return stringService;
    }

    public ParserService getParserService() {
        return parserService;
    }
}
