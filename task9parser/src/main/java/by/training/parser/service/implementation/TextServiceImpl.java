package by.training.parser.service.implementation;

import by.training.parser.entity.Composite;
import by.training.parser.service.TextService;

public class TextServiceImpl implements TextService {

    @Override
    public String recoverText(Composite composite) {
        return composite.recoverText();
    }
}
