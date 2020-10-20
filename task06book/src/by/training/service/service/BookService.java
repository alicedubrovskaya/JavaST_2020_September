package by.training.service.service;

import by.training.entity.Book;
import by.training.entity.BookInformation;

import java.util.Set;

public interface BookService {
    void createNewBook(Book book);

    void createNewBooks(Set<Book> books);

    Set<Book> getFromFile(String filePath);

    void saveToFile(Set<Book> books);

    void deleteBook(String title);

    void validate(Book book);

    void validate(BookInformation bookInformation, String information);

    void validate(Set<String> authors);
}
