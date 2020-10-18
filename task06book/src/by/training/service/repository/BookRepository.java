package by.training.service.repository;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;

import java.io.IOException;

public interface BookRepository {
    Book get(String title);

    void add(Book book) throws BookAlreadyExistsException;

    void remove(String title);

    Book getFromFile(String filePath) throws IOException;
}
