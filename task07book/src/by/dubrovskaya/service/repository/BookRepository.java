package by.dubrovskaya.service.repository;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.exception.BookAlreadyExistsException;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;

import java.util.Set;

/**
 * Class that is a repository
 */
public interface BookRepository {
    void add(Book book) throws BookAlreadyExistsException;

    void remove(String title);

    Set<Book> getFromFile(String filePath);

    void saveToFile(Book book, boolean emptyFile);

    Set<Book> query(Query currentQuery) throws BooksNotFoundException;
}
