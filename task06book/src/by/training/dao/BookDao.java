package by.training.dao;

import by.training.entity.Book;

import java.util.Set;

public interface BookDao {
    Set<Book> readFromFile(String filePath);

    void writeToFile(Book book);
}
