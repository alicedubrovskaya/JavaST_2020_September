package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches publications by number of pages
 */
public class SearchByNumberOfPagesQuery implements Query {
    private int numberOfPages;

    public SearchByNumberOfPagesQuery(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    /**
     * Searches publications by number of pages
     *
     * @param publications
     * @return resulting set of found publications
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (publication.getNumberOfPages() == numberOfPages) {
                result.add(publication);
            }
        }
        return result;
    }
}