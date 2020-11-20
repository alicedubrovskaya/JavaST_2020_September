package by.training.parser.dao;

import by.training.parser.entity.Composite;

public interface TextDao {
    void add(Composite composite);

    Composite get();
}
