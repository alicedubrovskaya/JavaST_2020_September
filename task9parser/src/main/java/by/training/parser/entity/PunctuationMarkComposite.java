package by.training.parser.entity;

import java.util.stream.Collectors;

public class PunctuationMarkComposite extends Composite {
    @Override
    public String recoverText() {
        StringBuilder result = new StringBuilder();
        for (Component component: components){
            result.append(component.recoverText());
        }
        return result.toString();
//        return components.stream()
//                .map(Component::recoverText)
//                .collect(Collectors.joining());
    }
}
