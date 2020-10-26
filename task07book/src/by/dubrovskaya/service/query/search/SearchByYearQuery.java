package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
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
     * @param publications
     * @return resulting set of found books
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            Book book = (Book) publication;
            if (book.getYearOfPublishing() == year) {
                result.add(publication);
            }
        }
        return result;
    }
}
