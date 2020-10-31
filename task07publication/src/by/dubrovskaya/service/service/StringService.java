package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;

import java.util.List;

public interface StringService {
    boolean startsWith(String phrase, String string);

    boolean contains(String phrase, String string);

    Publication parse(String line);

    Publication receiveBook(List<String> parameters);

    Publication receiveJournal(List<String> parameters);

    List<String> receiveAuthors(String string);

    List<String> receiveParameters(String line);
}
