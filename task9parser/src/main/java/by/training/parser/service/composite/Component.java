package by.training.parser.service.composite;

public interface Component {
    void add(Component component);

    Component getChild(int index);

    void operation();

    void remove(Component component);
}
