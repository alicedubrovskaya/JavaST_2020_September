package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

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
     * @param books
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
        List<Book> list = new LinkedList<Book>(books);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
