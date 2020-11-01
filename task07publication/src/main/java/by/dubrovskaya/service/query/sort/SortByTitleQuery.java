package by.dubrovskaya.service.query.sort;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.sort.comparator.TitleComparator;

import java.util.*;

/**
 * Class is an implementation of interface Query. Sorts books by title
 */
public class SortByTitleQuery implements Query {
    private boolean isAscending;

    public SortByTitleQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

    /**
     * Sorts books by title
     *
     * @param publications
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Optional<Set<Publication>> query(Set<Publication> publications) {
        Comparator<Publication> comparator = new TitleComparator();
        List<Publication> list = new LinkedList<Publication>(publications);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        Set<Publication> linkedList = new LinkedHashSet<>(list);
        return Optional.ofNullable(linkedList);
    }
}
