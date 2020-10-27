package by.dubrovskaya.service.query;

import by.dubrovskaya.entity.Publication;

import java.util.Set;

/**
 * Interface of query to repository
 *
 * @author Alisa Dubrovskaya
 */
public interface Query {
    Set<Publication> query(Set<Publication> publications);
}
