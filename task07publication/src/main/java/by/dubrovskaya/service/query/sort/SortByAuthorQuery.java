package by.dubrovskaya.service.query.sort;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.sort.comparator.AuthorsComparator;

import java.util.*;

/**
 * Class is an implementation of interface Query. Sorts books by author
 */
public class SortByAuthorQuery implements Query {
    private boolean isAscending;

    public SortByAuthorQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

    /**
     * Sorts books by first author of a book
     *
     * @param publications
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Optional<Set<Publication>> query(Set<Publication> publications) {
        Comparator<Publication> comparator = new AuthorsComparator();
        List<Publication> list = new LinkedList<Publication>(publications);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        Set<Publication> linkedList = new LinkedHashSet<>(list);
        return Optional.ofNullable(linkedList);
    }
}
