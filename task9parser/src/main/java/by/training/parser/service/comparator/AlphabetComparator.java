package by.training.parser.service.comparator;

import by.training.parser.entity.Component;

import java.util.Comparator;

public class AlphabetComparator implements Comparator<Component> {
    @Override
    public int compare(Component component, Component t1) {
        return component.recoverText().compareTo(t1.recoverText());
    }
}
