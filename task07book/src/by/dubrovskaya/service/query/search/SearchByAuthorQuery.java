package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches books by author
 */
public class SearchByAuthorQuery implements Query {
    private String author;

    public SearchByAuthorQuery(String author) {
        this.author = author;
    }

    /**
     * Searches books by author
     *
     * @param books
     * @return resulting set of found books
     */
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
