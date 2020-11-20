package by.training.parser.service.comparator;

import by.training.parser.entity.Component;

import java.util.Comparator;

public class WordComparator implements Comparator<Component> {

    @Override
    public int compare(Component lexeme, Component lexeme2) {
        //TODO
        String word1 = lexeme.getCountOfChildren() == 1 ? lexeme.getChild(0).recoverText() : lexeme.getChild(1).recoverText();
        String word2 = lexeme2.getCountOfChildren() == 1 ? lexeme2.getChild(0).recoverText() : lexeme2.getChild(1).recoverText();

        return Integer.compare(word1.length(), word2.length());
    }
}
