package by.training.data;

import by.training.entity.Book;
import by.training.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public void delete(Book book) {
        for (Book bookInList : books) {
            if (bookInList.equals(book)) {
                books.remove(book);
            }
        }
    }

    public Book get(String title){
        for (Book book: books){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        throw new BookNotFoundException();
    }
}
