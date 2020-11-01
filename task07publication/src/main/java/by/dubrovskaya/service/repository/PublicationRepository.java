package by.dubrovskaya.service.repository;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.exception.BookAlreadyExistsException;
import by.dubrovskaya.exception.BookNotFoundException;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;

import java.util.List;
import java.util.Set;

/**
 * Class that is a repository
 */
public interface PublicationRepository {
    int generateId();

    void add(Publication publication) throws BookAlreadyExistsException;

    void update(Publication publication);

    void remove(String title) throws BookNotFoundException;

    List<String> getFromFile(String filePath);

    void saveToFile(Publication publication, boolean emptyFile);

    Set<Publication> query(Query currentQuery) throws BooksNotFoundException;
}
