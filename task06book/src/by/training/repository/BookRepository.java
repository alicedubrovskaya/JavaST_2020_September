package by.training.repository;

import by.training.entity.Book;

public interface BookRepository {
    Book get(String title);
    void add(Book book);
    void remove(Book book);
}
