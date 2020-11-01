package by.dubrovskaya.service.query.sort;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.sort.comparator.PagesComparator;

import java.util.*;

/**
 * Class is an implementation of interface Query. Sorts books by number of pages
 */
public class SortByPagesQuery implements Query {
    private boolean isAscending;

    public SortByPagesQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

    /**
     * Sorts books by number of pages
     *
     * @param publications
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Optional<Set<Publication>> query(Set<Publication> publications) {
        Comparator<Publication> comparator = new PagesComparator();
        List<Publication> list = new LinkedList<Publication>(publications);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        Set<Publication> linkedList = new LinkedHashSet<>(list);
        return Optional.ofNullable(linkedList);
    }
}
