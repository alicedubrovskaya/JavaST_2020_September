package by.training.parser.entity;

public class LexemeComposite extends Composite {

    @Override
    public String recoverText() {
        StringBuilder result = new StringBuilder();
        components.stream().filter(component -> component instanceof WordComposite)
                .map(Component::recoverText)
                .forEach(result::append);

        components.stream().filter(component -> component instanceof PunctuationMarkComposite)
                .map(Component::recoverText)
                .forEach(result::append);
        return result.toString();
    }
}
