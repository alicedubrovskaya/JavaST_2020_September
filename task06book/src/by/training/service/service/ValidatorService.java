package by.training.service.service;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;

import java.util.Set;

public interface ValidatorService {
    void validate(Book book);

    void validate(BookInformation bookInformation, String information);

    void validate(Set<String> authors);
}
