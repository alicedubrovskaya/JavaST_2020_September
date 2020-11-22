package by.training.parser.service;

import by.training.parser.entity.Composite;

/**
 * Interface for work with text
 */
public interface TextService {
    void saveText(String text);

    Composite readText();

    Composite parse(String text);

    String recoverText(Composite composite);
}
