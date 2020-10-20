package by.training.service.query;

import by.training.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class SearchByYearQuery implements Query {
    private int year;

    public SearchByYearQuery(int year) {
        this.year = year;
    }

    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getYearOfPublishing() == year) {
                result.add(book);
            }
        }
        return result;
    }
}
