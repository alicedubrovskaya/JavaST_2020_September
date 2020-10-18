package by.training.entity.data;

import by.training.entity.Book;
import by.training.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
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
