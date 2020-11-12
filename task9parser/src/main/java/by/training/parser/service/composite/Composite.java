package by.training.parser.service.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public void operation() {

    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }
}
