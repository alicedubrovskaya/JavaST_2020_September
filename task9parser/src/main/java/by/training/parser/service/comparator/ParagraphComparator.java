package by.training.parser.service.comparator;

import by.training.parser.entity.Component;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Component> {

    @Override
    public int compare(Component paragraph, Component paragraph2) {
        if (paragraph.getCountOfChildren() > paragraph2.getCountOfChildren()) {
            return 1;
        } else if (paragraph.getCountOfChildren() < paragraph2.getCountOfChildren()) {
            return -1;
        } else {
            return 0;
        }
    }
}
