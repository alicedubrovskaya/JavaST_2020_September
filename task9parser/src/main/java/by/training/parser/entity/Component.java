package by.training.parser.entity;

public interface Component {
    void add(Component component);

    Component getChild(int index);

    int getCountOfChildren();

    void operation();

    void remove(Component component);
}
