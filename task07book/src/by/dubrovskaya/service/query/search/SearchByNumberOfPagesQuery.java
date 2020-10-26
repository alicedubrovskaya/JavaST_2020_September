package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches books by number of pages
 */
public class SearchByNumberOfPagesQuery implements Query {
    private int numberOfPages;

    public SearchByNumberOfPagesQuery(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    /**
     * Searches books by number of pages
     *
     * @param books
     * @return resulting set of found books
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getNumberOfPages() == numberOfPages) {
                result.add(book);
            }
        }
        return result;
    }
}