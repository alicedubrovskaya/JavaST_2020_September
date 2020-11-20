package by.training.parser.entity;

import java.util.List;

public interface Component {
    void add(Component component);

    Component getChild(int index);

    List<Component> getChildren();

    int getCountOfChildren();

    String recoverText();

    void remove(Component component);
}
