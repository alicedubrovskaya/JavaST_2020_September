package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Class is an interface, that is responsible for publications finding
 */
public interface SearchService {
    Optional<Set<Publication>> findByTag(SearchType searchType, Map<String, Object> tagsInfo);
}
