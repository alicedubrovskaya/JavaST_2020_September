package by.training.service.service;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;

import java.util.Set;

/**
 * Class is an interface, that is responsible for finding of books
 */
public interface FindBookService {
    Set<Book> findByTag(BookInformation bookInformation, String tag);
}
