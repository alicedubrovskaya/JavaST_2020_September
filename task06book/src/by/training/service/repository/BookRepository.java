package by.training.service.repository;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.Query;

import java.io.IOException;
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
