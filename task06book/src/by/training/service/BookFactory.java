package by.training.service;

import by.training.service.implementation.BookServiceImpl;

public class BookFactory {
    private static final BookFactory instance = new BookFactory();

    private final BookService bookService = new BookServiceImpl();

    public static BookFactory getInstance() {
        return instance;
    }

    public BookService getBookService() {
        return bookService;
    }
}
