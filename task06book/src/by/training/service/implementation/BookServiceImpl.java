package by.training.service.implementation;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.exception.InvalidBookException;
import by.training.service.BookValidator;
import by.training.service.repository.BookRepository;
import by.training.service.repository.BookRepositoryImpl;
import by.training.service.BookService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public void createNewBook(Book book) {
        try {
            bookRepository.add(book);
        } catch (BookAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Book> getFromFile(String filePath) {
        List<Book> books = new ArrayList<>();
        try {
            books = bookRepository.getFromFile(filePath);
            for (Book book : books) {
                bookRepository.add(book);
            }
        } catch (IOException | BookAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
        return books;
    }

    @Override
    public void deleteBook(String title) {
        try {
            bookRepository.remove(title);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void validate(Book book) throws InvalidBookException {
        BookValidator bookValidator = new BookValidator();
        if (!bookValidator.isValidBook(book)) {
            throw new InvalidBookException();
        }
    }
}
