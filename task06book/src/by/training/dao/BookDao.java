package by.training.dao;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;

public interface BookDao {
    void create(Book book) throws BookAlreadyExistsException;

    void delete(String title);

    Book get(String title);
}
