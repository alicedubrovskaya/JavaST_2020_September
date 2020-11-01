package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches publications by title
 */
public class SearchByTitleQuery implements Query {

    private String title;

    public SearchByTitleQuery(String title) {
        this.title=title;
    }

    /**
     * Searches publications by title
     *
     * @param publications
     * @return resulting set of found publications
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication: publications){
            if (publication.getTitle().equals(title)){
                result.add(publication);
            }
        }
        return result;
    }
}
