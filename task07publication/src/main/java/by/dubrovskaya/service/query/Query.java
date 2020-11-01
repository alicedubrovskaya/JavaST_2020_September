package by.dubrovskaya.service.query;

import by.dubrovskaya.entity.Publication;

import java.util.Optional;
import java.util.Set;

/**
 * Interface of query to repository
 *
 * @author Alisa Dubrovskaya
 */
public interface Query {
    Optional<Set<Publication>> query(Set<Publication> publications);
}
