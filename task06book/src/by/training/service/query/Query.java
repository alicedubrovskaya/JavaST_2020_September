package by.training.service.query;

import by.training.entity.Book;

import java.util.Set;

/**
 * Interface of query to repository
 *
 * @author Alisa Dubrovskaya
 */
public interface Query {
    Set<Book> query(Set<Book> books);
}
