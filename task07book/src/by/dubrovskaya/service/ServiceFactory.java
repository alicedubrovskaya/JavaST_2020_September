package by.dubrovskaya.service;

import by.dubrovskaya.service.repository.BookRepository;
import by.dubrovskaya.service.repository.BookRepositoryImpl;
import by.dubrovskaya.service.service.*;
import by.dubrovskaya.service.service.implementation.*;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BookRepository bookRepository = new BookRepositoryImpl();
    private final BookService bookService = new BookServiceImpl(bookRepository);
    private final FindBookService findBookService = new FindBookServiceImpl(bookRepository);
    private final SortBookService sortBookService = new SortBookServiceImpl(bookRepository);
    private final FileService fileService = new FileServiceImpl(bookRepository);
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
