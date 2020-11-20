package by.training.parser.dao;

import by.training.parser.entity.Composite;
import by.training.parser.entity.storage.TextStorage;

public class TextDaoImpl implements TextDao {
    private TextStorage storage = TextStorage.getINSTANCE();

    @Override
    public void add(Composite composite) {
        storage.setText(composite);
    }

    @Override
    public Composite get() {
        return storage.getText();
    }
}
