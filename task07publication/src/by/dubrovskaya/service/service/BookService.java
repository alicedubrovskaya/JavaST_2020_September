package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;

import java.util.Set;

/**
 * Class is an interface, that is responsible for adding and deleting books
 */
public interface BookService {
    void createNewPublication(Publication publication);

    void createNewPublications(Set<Publication> publications);

    void deletePublication(String title);
}
