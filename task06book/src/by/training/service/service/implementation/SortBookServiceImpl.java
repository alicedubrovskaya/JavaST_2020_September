package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.entity.BookInformation;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.Query;
import by.training.service.query.sort.*;
import by.training.service.repository.BookRepository;
import by.training.service.service.SortBookService;

import java.util.HashSet;
import java.util.Set;

public class SortBookServiceImpl implements SortBookService {
    private BookRepository bookRepository;

    public SortBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> sortByTag(BookInformation bookInformation) {
        Set<Book> books = new HashSet<>();
        Query query = null;
        switch (bookInformation) {
            case TITLE:
                query = new SortByTitleQuery();
                break;
            case YEAR:
                query = new SortByYearQuery();
                break;
            case PUBLISHING_HOUSE:
                query = new SortByPublishingHouseQuery();
                break;
            case PAGES:
                query = new SortByNumberOfPagesQuery();
                break;
            case AUTHORS:
                query = new SortByAuthorQuery();
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
