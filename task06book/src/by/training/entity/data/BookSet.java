package by.training.entity.data;

import by.training.entity.Book;
import by.training.exception.BookNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class BookSet {
    private Set<Book> books =new HashSet<>();

    public boolean add(Book book) {
        return books.add(book);
    }

    public void delete(String title) {
        try{
            Book book = get(title);
            books.remove(book);
        }
        catch (BookNotFoundException e){
            throw new BookNotFoundException(title);
        }
    }

    public Book get(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new BookNotFoundException(title);
    }

    public boolean bookExists(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
