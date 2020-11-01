package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches publications by author
 */
public class SearchByAuthorQuery implements Query {
    private String author;

    public SearchByAuthorQuery(String author) {
        this.author = author;
    }

    /**
     * Searches publications by author
     *
     * @param publications
     * @return resulting set of found publications
     */
    @Override
    public Optional<Set<Publication>> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (publication.getAuthors().contains(author)) {
                result.add(publication);
            }
        }
        return Optional.ofNullable(result);
    }
}
