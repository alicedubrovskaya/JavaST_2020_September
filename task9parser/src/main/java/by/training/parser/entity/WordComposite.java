package by.training.parser.entity;

import java.util.stream.Collectors;

public class WordComposite extends Composite {
    @Override
    public String recoverText() {
        String string =  components.stream()
                .map(Component::recoverText)
                .collect(Collectors.joining());
        return string;
    }
}
