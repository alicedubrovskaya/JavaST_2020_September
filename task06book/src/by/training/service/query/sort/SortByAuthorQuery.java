package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

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
     * @param books
     * @return sorted set of books (LinkedSet)
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book book, Book t1) {
                String firstAuthor = book.getFirstAuthor();
                String secondAuthor = book.getFirstAuthor();
                return firstAuthor.compareTo(secondAuthor);
            }
        };
        List<Book> list = new LinkedList<Book>(books);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
