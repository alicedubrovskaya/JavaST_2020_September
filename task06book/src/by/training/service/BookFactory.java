package by.training.service;

import by.training.service.repository.BookRepository;
import by.training.service.repository.BookRepositoryImpl;
import by.training.service.service.FindBookService;
import by.training.service.service.implementation.BookServiceImpl;
import by.training.service.service.BookService;
import by.training.service.service.implementation.FindBookServiceImpl;

public class BookFactory {
    private static final BookFactory instance = new BookFactory();

    private final BookRepository bookRepository = new BookRepositoryImpl();
    private final BookService bookService = new BookServiceImpl(bookRepository);
    private final FindBookService findBookService = new FindBookServiceImpl(bookRepository);

    public static BookFactory getInstance() {
        return instance;
    }

    public BookService getBookService() {
        return bookService;
    }

    public FindBookService getFindBookService() {
        return findBookService;
    }
}
