package by.training.service.service;

import by.training.entity.Book;
import by.training.entity.BookInformation;

import java.util.Set;

public interface FindBookService {
    Set<Book> findByTag(BookInformation bookInformation, String tag);
}