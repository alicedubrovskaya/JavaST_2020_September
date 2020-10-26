package by.dubrovskaya.service.query;

import by.dubrovskaya.entity.Book;

import java.util.Set;

/**
 * Interface of query to repository
 *
 * @author Alisa Dubrovskaya
 */
public interface Query {
    Set<Book> query(Set<Book> books);
}
