package by.training.service;

import by.training.entity.Book;

import java.util.List;

public interface BookService {
    void createNewBook(Book book);

    List<Book> getFromFile(String filePath);

    Book findBook(String title);

    void deleteBook(String title);

    void validate(Book book);
}
