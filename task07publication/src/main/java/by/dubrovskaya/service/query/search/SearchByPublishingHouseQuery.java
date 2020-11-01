package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches publications by publishing house
 */
public class SearchByPublishingHouseQuery implements Query {

    private String publishingHouse;

    public SearchByPublishingHouseQuery(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }


    /**
     * Searches publications by publishing house
     *
     * @param publications
     * @return resulting set of found publications
     */
    @Override
    public Optional<Set<Publication>> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (publication.getPublishingHouse().equals(publishingHouse)) {
                result.add(publication);
            }
        }
        return Optional.ofNullable(result);
    }
}
