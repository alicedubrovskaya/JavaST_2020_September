package by.training.parser.dao.impl;

import by.training.parser.dao.TextDao;
import by.training.parser.entity.Composite;
import by.training.parser.entity.storage.TextStorage;

/**
 * Class that is an implementation of interface TextDao
 *
 * @author Alisa Dubrovskaya
 */

public class TextDaoImpl implements TextDao {
    private TextStorage storage = TextStorage.getINSTANCE();

    @Override
    public void add(Composite composite) {
        storage.setText(composite);
    }

    @Override
    public void add(String text) {
        storage.setStringText(text);
    }

    @Override
    public Composite get() {
        return storage.getText();
    }
}
