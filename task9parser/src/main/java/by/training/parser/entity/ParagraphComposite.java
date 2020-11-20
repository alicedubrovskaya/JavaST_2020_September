package by.training.parser.entity;

import java.util.stream.Collectors;

public class ParagraphComposite extends Composite {
    @Override
    public String recoverText() {
        return components.stream()
                .map(Component::recoverText)
                .collect(Collectors.joining(" "));
    }
}
