package by.training.service.query.search;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches books by title
 */
public class SearchByTitleQuery implements Query {

    private String title;

    public SearchByTitleQuery(String title) {
        this.title=title;
    }

    /**
     * Searches books by title
     *
     * @param books
     * @return resulting set of found books
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book: books){
            if (book.getTitle().equals(title)){
                result.add(book);
            }
        }
        return result;
    }
}
