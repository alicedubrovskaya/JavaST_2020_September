package by.training.service.service;

import by.training.entity.Book;

import java.util.Set;

public interface BookService {
    void createNewBook(Book book);

    void createNewBooks(Set<Book> books);

    void deleteBook(String title);
}
