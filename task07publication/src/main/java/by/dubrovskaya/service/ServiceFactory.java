package by.dubrovskaya.service;

import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.repository.PublicationRepositoryImpl;
import by.dubrovskaya.service.service.*;
import by.dubrovskaya.service.service.implementation.*;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 */
public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {
    }

    private final PublicationRepository publicationRepository = new PublicationRepositoryImpl();
    private final BookService bookService = new BookServiceImpl(publicationRepository);
    private final SearchService searchService = new SearchServiceImpl(publicationRepository);
    private final SortService sortService = new SortServiceImpl(publicationRepository);
    private final ValidatorService validatorService = new ValidatorServiceImpl(new PublicationValidator());
    private final StringService stringService = new StringServiceImpl(validatorService);
    private final FileService fileService = new FileServiceImpl(publicationRepository, stringService, validatorService);
    private final NumberService numberService = new NumberServiceImpl();


    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public BookService getBookService() {
        return bookService;
    }

    public SortService getSortService() {
        return sortService;
    }

    public SearchService getSearchService() {
        return searchService;
    }

    public FileService getFileService() {
        return fileService;
    }

    public ValidatorService getValidatorService() {
        return validatorService;
    }

    public StringService getStringService() {
        return stringService;
    }

    public NumberService getNumberService() {
        return numberService;
    }
}
