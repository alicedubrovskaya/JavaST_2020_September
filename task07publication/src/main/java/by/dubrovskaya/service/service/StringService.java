package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;

import java.util.List;
import java.util.Optional;

public interface StringService {
    boolean startsWith(String phrase, String string);

    boolean contains(String phrase, String string);

    Optional<Publication> parse(String line);

    Optional<Publication> receiveBook(List<String> parameters);

    Optional<Publication> receiveJournal(List<String> parameters);

    List<String> receiveAuthors(String string);

    List<String> receiveParameters(String line);
}
