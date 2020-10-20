package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.*;

public class SortByAuthorQuery implements Query {
    private boolean isAscending;

    public SortByAuthorQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

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
