package by.training.service.service;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;
import by.training.entity.enumeration.Sorting;

import java.util.Set;

/**
 * Class is an interface, that is responsible for sorting of books
 */
public interface SortBookService {
    Set<Book> sortByTag(BookInformation bookInformation, Sorting sorting);
}
