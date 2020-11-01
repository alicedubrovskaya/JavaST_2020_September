package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches books by year
 */
public class SearchByIdQuery implements Query {
    private int id;

    public SearchByIdQuery(int id) {
        this.id = id;
    }

    /**
     * Searches publications by id
     *
     * @param publications
     * @return resulting set of found publications
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (publication.getId() == id) {
                result.add(publication);
            }
        }
        return result;
    }
}
