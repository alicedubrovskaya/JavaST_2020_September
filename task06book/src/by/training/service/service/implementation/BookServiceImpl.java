package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.entity.BookInformation;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.exception.InvalidBookException;
import by.training.exception.InvalidInvormationException;
import by.training.service.repository.BookRepository;
import by.training.service.service.BookService;
import by.training.service.service.BookValidator;

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
    public Set<Book> getFromFile(String filePath) {
        return bookRepository.getFromFile(filePath);
    }

    @Override
    public void saveToFile(Set<Book> books) {
        for (Book book: books){
            bookRepository.saveToFile(book);
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

    @Override
    public void validate(Book book) throws InvalidBookException {
        BookValidator bookValidator = new BookValidator();
        //TODO catching
        if (!bookValidator.isValidBook(book)) {
            throw new InvalidBookException();
        }
    }

    @Override
    public void validate(BookInformation bookInformation, String information) {
        BookValidator bookValidator = new BookValidator();
        boolean isValid = true;
        switch (bookInformation) {
            case TITLE:
                isValid = bookValidator.titleIsValid(information);
                break;
            case PUBLISHING_HOUSE:
                isValid = bookValidator.publishingHouseIsValid(information);
                break;
            case YEAR:
                isValid = bookValidator.yearIsValid(Integer.valueOf(information));
                break;
            case PAGES:
                isValid = bookValidator.pagesIsValid(Integer.valueOf(information));
                break;
        }
        if (!isValid) {
            throw new InvalidInvormationException();
        }
    }

    @Override
    public void validate(Set<String> authors) {
        BookValidator bookValidator = new BookValidator();
        if (!bookValidator.authorIsValid(authors)) {
            throw new InvalidBookException();
        }
    }
}
