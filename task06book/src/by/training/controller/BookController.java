package by.training.controller;

import by.training.entity.Book;
import by.training.service.BookFactory;
import by.training.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController() {
        BookFactory bookFactory = BookFactory.getInstance();
        this.bookService = bookFactory.getBookService();
    }

    public List<Book> dataLoading(String filePath) {
        List<Book> books = bookService.getFromFile(filePath);
        createNewBooks(books);
        return books;
    }

    public void createNewBooks(List<Book> books) {
        for (Book book : books) {
            bookService.validate(book);
            bookService.createNewBook(book);
        }
    }


    public void createNewBook(String title, int numberOfPages, int yearOfPublishing, String publishingHouse, List<String> authors) {
        Book book = new Book(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
        bookService.validate(book);
        bookService.createNewBook(book);
    }

    public void deleteBook(String title) {
        bookService.deleteBook(title);
    }

    public Book getBook(String title) {
        return bookService.findBook(title);
    }
}
