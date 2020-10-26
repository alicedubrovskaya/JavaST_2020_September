package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.enumeration.BookInformation;

import java.util.Set;

/**
 * Class is an interface, that is responsible for finding of books
 */
public interface FindBookService {
    Set<Book> findByTag(BookInformation bookInformation, String tag);
}
