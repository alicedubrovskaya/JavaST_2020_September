package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;

public interface StringService {
    boolean startsWith(String phrase, String string);

    boolean contains(String phrase, String string);

    Publication parse(String line);

    Publication receiveParameters(String[] subLines);
}
