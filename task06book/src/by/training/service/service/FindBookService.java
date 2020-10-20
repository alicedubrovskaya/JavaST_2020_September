package by.training.service.service;

import by.training.entity.Book;

import java.util.Set;

public interface FindBookService {
    Set<Book> findByTitle(String title);
}
