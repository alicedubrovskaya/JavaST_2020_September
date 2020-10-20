package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.Query;
import by.training.service.query.SearchByTitleQuery;
import by.training.service.repository.BookRepository;
import by.training.service.service.FindBookService;

import java.util.HashSet;
import java.util.Set;

public class FindBookServiceImpl implements FindBookService {
    private BookRepository bookRepository;

    public FindBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> findByTitle(String title) {
        Query query = new SearchByTitleQuery(title);
        Set<Book> books = new HashSet<>();
        try {
            books = bookRepository.query(query);
        } catch (BooksNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return books;
    }
}
