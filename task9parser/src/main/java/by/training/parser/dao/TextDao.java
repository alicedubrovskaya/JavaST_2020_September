package by.training.parser.dao;

import by.training.parser.entity.Composite;

/**
 * Interface that works with storage
 *
 * @author Alisa Dubrovskaya
 */
public interface TextDao {
    void add(Composite composite);

    void add(String text);

    Composite get();
}
