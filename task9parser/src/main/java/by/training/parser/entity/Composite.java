package by.training.parser.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {
    List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public int getCountOfChildren() {
        return components.size();
    }

    @Override
    public String recoverText() {
        //TODO
        return "";
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }
}
