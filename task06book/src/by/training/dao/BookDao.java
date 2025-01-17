package by.training.dao;

import by.training.entity.Book;

import java.util.Set;

/**
 * Interface that works with files
 *
 * @author Alisa Dubrovskaya
 */
public interface BookDao {
    Set<Book> readFromFile(String filePath);

    void writeToFile(Book book, boolean emptyFile);
}
