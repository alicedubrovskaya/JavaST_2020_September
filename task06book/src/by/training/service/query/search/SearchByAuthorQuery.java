package by.training.service.query.search;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.HashSet;
import java.util.Set;

public class SearchByAuthorQuery implements Query {
    private String author;

    public SearchByAuthorQuery(String author) {
        this.author = author;
    }

    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                result.add(book);
            }
        }
        return result;
    }
}
