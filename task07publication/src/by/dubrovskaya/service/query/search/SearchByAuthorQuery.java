package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
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
     * @param publications
     * @return resulting set of found books
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (publication.getAuthors().contains(author)) {
                result.add(publication);
            }
        }
        return result;
    }
}
