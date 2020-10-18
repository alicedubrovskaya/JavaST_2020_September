package by.training.service;

import by.training.entity.Book;

public interface BookService {
    void createNewBook(Book book);

    Book findBook(String title);

    void deleteBook(String title);

    void validate(Book book);
}
