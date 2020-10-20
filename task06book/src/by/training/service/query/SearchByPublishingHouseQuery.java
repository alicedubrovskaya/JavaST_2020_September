package by.training.service.query;

import by.training.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class SearchByPublishingHouseQuery implements Query {

    private String publishingHouse;

    public SearchByPublishingHouseQuery(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

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
