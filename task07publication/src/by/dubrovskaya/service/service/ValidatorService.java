package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;

import java.util.Map;
import java.util.Set;

/**
 * Class is an interface, that is responsible for validation
 */
public interface ValidatorService {
    boolean validate(String title, String numberOfPages, String publishingHouse, Set<String> authors);

    boolean validateBook(String yearOfPublishing, String genre);

    boolean validateJournal(String periodicity, String foundationDate);

    void validate(SearchType searchType, Map<String, Object> information);

    void validate(Set<String> authors);
}
