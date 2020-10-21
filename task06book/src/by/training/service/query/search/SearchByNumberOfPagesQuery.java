package by.training.service.query.search;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.HashSet;
import java.util.Set;

public class SearchByNumberOfPagesQuery implements Query {
    private int numberOfPages;

    public SearchByNumberOfPagesQuery(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getNumberOfPages() == numberOfPages) {
                result.add(book);
            }
        }
        return result;
    }
}