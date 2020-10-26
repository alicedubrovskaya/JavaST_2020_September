package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches books by year
 */
public class SearchByYearQuery implements Query {
    private int year;

    public SearchByYearQuery(int year) {
        this.year = year;
    }

    /**
     * Searches books by year
     *
     * @param books
     * @return resulting set of found books
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getYearOfPublishing() == year) {
                result.add(book);
            }
        }
        return result;
    }
}
