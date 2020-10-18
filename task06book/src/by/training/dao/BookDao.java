package by.training.dao;

import by.training.entity.Book;

public interface BookDao {
    void create(Book book);

    void delete(Book book);

    Book get(String title);
}
