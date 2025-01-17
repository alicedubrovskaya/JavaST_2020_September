package by.training.parser.entity;

import java.util.List;

public class SymbolLeaf implements Component {
    private char symbol;

    public SymbolLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String recoverText() {
        return String.valueOf(symbol);
    }

    //TODO exceptions
    @Override
    public void add(Component component) {

    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public int getCountOfChildren() {
        return 0;
    }
}
