package by.training.service.repository;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;

public interface BookRepository {
    Book get(String title);

    void add(Book book) throws BookAlreadyExistsException;

    void remove(String title);
}
