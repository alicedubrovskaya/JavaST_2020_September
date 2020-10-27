package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.ServiceFactory;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.service.NumberService;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query.
 * Searches publications with id in specified interval
 */
public class SearchByIntervalOfId implements Query {
    private int leftBoundOfInterval;
    private int rightBoundOfInterval;
    private NumberService numberService;

    public SearchByIntervalOfId(int leftBound, int rightBound) {
        this.leftBoundOfInterval = leftBound;
        this.rightBoundOfInterval = rightBound;
        this.numberService = ServiceFactory.getInstance().getNumberService();
    }

    /**
     * Searches publications with id in specified interval
     *
     * @param publications
     * @return
     */
    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (numberService.includedToInterval(leftBoundOfInterval, rightBoundOfInterval, publication.getId())) {
                result.add(publication);
            }
        }
        return result;
    }
}
