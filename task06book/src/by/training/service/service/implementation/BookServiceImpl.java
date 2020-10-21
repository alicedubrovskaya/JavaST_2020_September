package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.service.repository.BookRepository;
import by.training.service.service.BookService;

import java.util.Set;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createNewBook(Book book) {
        try {
            bookRepository.add(book);
        } catch (BookAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    public void createNewBooks(Set<Book> books) {
        for (Book book : books) {
            createNewBook(book);
        }
    }

    @Override
    public void deleteBook(String title) {
        try {
            bookRepository.remove(title);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
