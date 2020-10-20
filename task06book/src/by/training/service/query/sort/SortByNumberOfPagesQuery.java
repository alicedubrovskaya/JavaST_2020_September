package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.*;

public class SortByNumberOfPagesQuery implements Query {
    private boolean isAscending;

    public SortByNumberOfPagesQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

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
