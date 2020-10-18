package by.training.service;

import by.training.entity.Book;

public interface BookService {
    void createNewBook(Book book);

    Book getFromFile(String filePath);

    Book findBook(String title);

    void deleteBook(String title);

    void validate(Book book);
}
