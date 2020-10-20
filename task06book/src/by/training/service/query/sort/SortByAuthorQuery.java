package by.training.service.query.sort;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.*;

public class SortByAuthorQuery implements Query {

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
        list.sort(comparator);
        return new HashSet<>(list);
    }
}
