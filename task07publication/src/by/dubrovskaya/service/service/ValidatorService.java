package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;

import java.util.Map;
import java.util.Set;

/**
 * Class is an interface, that is responsible for validation
 */
public interface ValidatorService {
    void validate(Publication publication);

    void validate(SearchType searchType, Map<String, Object> information);

    void validate(Set<String> authors);
}
