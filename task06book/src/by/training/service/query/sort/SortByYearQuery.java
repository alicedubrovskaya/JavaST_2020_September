package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.*;

/**
 * Class is an implementation of interface Query. Sorts books by year
 */
public class SortByYearQuery implements Query {
    private boolean isAscending;

    public SortByYearQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

    /**
     * Sorts books by year
     *
     * @param books
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getYearOfPublishing);
        List<Book> list = new LinkedList<Book>(books);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
