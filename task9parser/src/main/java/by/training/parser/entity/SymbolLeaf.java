package by.training.parser.entity;

public class SymbolLeaf implements Component {
    private char symbol;

    public SymbolLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void operation() {

    }

    //TODO exceptions
    @Override
    public void add(Component component) {

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
