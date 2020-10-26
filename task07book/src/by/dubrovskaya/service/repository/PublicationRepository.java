package by.dubrovskaya.service.repository;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.exception.BookAlreadyExistsException;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;

import java.util.Set;

/**
 * Class that is a repository
 */
public interface PublicationRepository {
    void add(Publication publication) throws BookAlreadyExistsException;

    void remove(String title);

    Set<Book> getFromFile(String filePath);

    void saveToFile(Book book, boolean emptyFile);

    Set<Publication> query(Query currentQuery) throws BooksNotFoundException;
}
