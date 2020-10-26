package by.dubrovskaya.service.query.sort;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.service.query.Query;

import java.util.*;

/**
 * Class is an implementation of interface Query. Sorts books by number of pages
 */
public class SortByNumberOfPagesQuery implements Query {
    private boolean isAscending;

    public SortByNumberOfPagesQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

    /**
     * Sorts books by number of pages
     *
     * @param books
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getNumberOfPages);
        List<Book> list = new LinkedList<Book>(books);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
