package by.training.dao;

import by.training.entity.Book;

import java.io.IOException;

public interface ReaderDao {
    Book readFromFile(String filePath) throws IOException;
}
