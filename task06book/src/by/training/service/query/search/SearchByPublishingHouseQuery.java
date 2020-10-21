package by.training.service.query.search;

import by.training.entity.Book;
import by.training.service.query.Query;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface Query. Searches books by publishing house
 */
public class SearchByPublishingHouseQuery implements Query {

    private String publishingHouse;

    public SearchByPublishingHouseQuery(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }


    /**
     * Searches books by publishing house
     *
     * @param books
     * @return resulting set of found books
     */
    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getPublishingHouse().equals(publishingHouse)) {
                result.add(book);
            }
        }
        return result;
    }
}
