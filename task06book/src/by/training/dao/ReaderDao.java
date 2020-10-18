package by.training.dao;

import by.training.entity.Book;

import java.io.IOException;
import java.util.List;

public interface ReaderDao {
    List<Book> readFromFile(String filePath) throws IOException;
}
