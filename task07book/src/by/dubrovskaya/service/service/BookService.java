package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Book;

import java.util.Set;

/**
 * Class is an interface, that is responsible for adding and deleting books
 */
public interface BookService {
    void createNewBook(Book book);

    void createNewBooks(Set<Book> books);

    void deleteBook(String title);
}
