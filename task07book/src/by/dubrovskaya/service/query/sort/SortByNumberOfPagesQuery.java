package by.dubrovskaya.service.query.sort;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
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
     * @param publications
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Comparator<Publication> comparator = Comparator.comparing(Publication::getNumberOfPages);
        List<Publication> list = new LinkedList<Publication>(publications);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
