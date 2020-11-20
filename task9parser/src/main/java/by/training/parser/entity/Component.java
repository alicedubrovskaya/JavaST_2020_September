package by.training.parser.entity;

public interface Component {
    void add(Component component);

    Component getChild(int index);

    int getCountOfChildren();

    String recoverText();

    void remove(Component component);
}
