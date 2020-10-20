package by.training.service;

import by.training.service.repository.BookRepository;
import by.training.service.repository.BookRepositoryImpl;
import by.training.service.service.FindBookService;
import by.training.service.service.SortBookService;
import by.training.service.service.implementation.BookServiceImpl;
import by.training.service.service.BookService;
import by.training.service.service.implementation.FindBookServiceImpl;
import by.training.service.service.implementation.SortBookServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BookRepository bookRepository = new BookRepositoryImpl();
    private final BookService bookService = new BookServiceImpl(bookRepository);
    private final FindBookService findBookService = new FindBookServiceImpl(bookRepository);
    private final SortBookService sortBookService = new SortBookServiceImpl(bookRepository);

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
}
