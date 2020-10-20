package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.*;

public class SortByPublishingHouseQuery implements Query {

    @Override
    public Set<Book> query(Set<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getPublishingHouse);
        List<Book> list = new LinkedList<Book>(books);
        list.sort(comparator);
        return new HashSet<>(list);
    }
}
