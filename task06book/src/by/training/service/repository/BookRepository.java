package by.training.service.repository;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;

import java.io.IOException;
import java.util.List;

public interface BookRepository {
    Book get(String title);

    void add(Book book) throws BookAlreadyExistsException;

    void remove(String title);

    List<Book> getFromFile(String filePath) throws IOException;
}
