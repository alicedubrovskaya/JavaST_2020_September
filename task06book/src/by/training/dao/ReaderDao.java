package by.training.dao;

import by.training.entity.Book;

import java.io.IOException;
import java.util.Set;

public interface ReaderDao {
    Set<Book> readFromFile(String filePath) throws IOException;
}
