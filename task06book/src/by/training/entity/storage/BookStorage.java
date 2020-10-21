package by.training.entity.storage;

import by.training.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class BookStorage {
    private static final BookStorage instance = new BookStorage();
    private Set<Book> books = new HashSet<>();

    public boolean add(Book book) {
        return books.add(book);
    }

    public void delete(Book book) {
        books.remove(book);
    }

    public static BookStorage getInstance() {
        return instance;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
