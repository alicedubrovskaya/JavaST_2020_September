package by.training.service.service;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;
import by.training.entity.enumeration.Sorting;

import java.util.Set;

public interface SortBookService {
    Set<Book> sortByTag(BookInformation bookInformation, Sorting sorting);
}
