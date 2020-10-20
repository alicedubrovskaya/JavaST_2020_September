package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.entity.BookInformation;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.*;
import by.training.service.query.search.*;
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
    public Set<Book> findByTag(BookInformation bookInformation, String tag) {
        Set<Book> books = new HashSet<>();
        Query query = null;
        switch (bookInformation) {
            case TITLE:
                query = new SearchByTitleQuery(tag);
                break;
            case YEAR:
                query = new SearchByYearQuery(Integer.valueOf(tag));
                break;
            case PUBLISHING_HOUSE:
                query = new SearchByPublishingHouseQuery(tag);
                break;
            case PAGES:
                query = new SearchByNumberOfPagesQuery(Integer.valueOf(tag));
                break;
            case AUTHORS:
                query = new SearchByAuthorQuery(tag);
                break;
            default:
        }

        try {
            books = bookRepository.query(query);
        } catch (BooksNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return books;
    }
}
