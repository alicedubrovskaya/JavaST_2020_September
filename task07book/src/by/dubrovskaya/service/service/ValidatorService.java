package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.enumeration.BookInformation;

import java.util.Set;

/**
 * Class is an interface, that is responsible for validation
 */
public interface ValidatorService {
    void validate(Book book);

    void validate(BookInformation bookInformation, String information);

    void validate(Set<String> authors);
}
