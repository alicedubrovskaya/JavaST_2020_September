package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.*;

public class SortByPublishingHouseQuery implements Query {
    private boolean isAscending;

    public SortByPublishingHouseQuery(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public Set<Book> query(Set<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getPublishingHouse);
        List<Book> list = new LinkedList<Book>(books);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
