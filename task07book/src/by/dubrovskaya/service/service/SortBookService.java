package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.enumeration.BookInformation;
import by.dubrovskaya.entity.enumeration.Sorting;

import java.util.Set;

/**
 * Class is an interface, that is responsible for sorting of books
 */
public interface SortBookService {
    Set<Book> sortByTag(BookInformation bookInformation, Sorting sorting);
}
