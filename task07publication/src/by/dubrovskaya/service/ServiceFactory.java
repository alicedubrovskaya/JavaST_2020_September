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
    private static final ServiceFactory instance = new ServiceFactory();

    private final PublicationRepository publicationRepository = new PublicationRepositoryImpl();
    private final BookService bookService = new BookServiceImpl(publicationRepository);
    private final FindBookService findBookService = new FindBookServiceImpl(publicationRepository);
    private final SortBookService sortBookService = new SortBookServiceImpl(publicationRepository);
    private final FileService fileService = new FileServiceImpl(publicationRepository);
    private final ValidatorService validatorService = new ValidatorServiceImpl();


    public static ServiceFactory getInstance() {
        return instance;
    }

    public BookService getBookService() {
        return bookService;
    }

    public SortBookService getSortBookService() {
        return sortBookService;
    }

    public FindBookService getFindBookService() {
        return findBookService;
    }

    public FileService getFileService() {
        return fileService;
    }

    public ValidatorService getValidatorService() {
        return validatorService;
    }
}
