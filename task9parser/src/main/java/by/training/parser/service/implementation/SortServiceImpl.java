package by.training.parser.service.implementation;

import by.training.parser.entity.Component;
import by.training.parser.entity.Composite;
import by.training.parser.entity.ParagraphComposite;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.SortService;
import by.training.parser.service.comparator.ParagraphComparator;
import by.training.parser.service.comparator.WordComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortServiceImpl implements SortService {

    @Override
    public Composite sortParagraphsByCountOfSentences(Composite text) {
        Comparator<Component> comparator = new ParagraphComparator();
        Composite sortedText = new TextComposite();

        List<Component> paragraphs = new ArrayList<>();
        for (int i = 0; i < text.getCountOfChildren(); i++) {
            paragraphs.add(text.getChild(i));
        }

        paragraphs.sort(comparator);
        paragraphs.forEach(sortedText::add);

        return sortedText;
    }

    /**
     * Doesnt return new Object
     * @param text
     * @return
     */
    @Override
    public Composite sortWordsInSentencesByLength(Composite text) {

        for (int i = 0; i < text.getCountOfChildren(); i++) {
            Component paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getCountOfChildren(); j++) {
                Component sentence = paragraph.getChild(j);
                List<Component> lexemesToSort = new ArrayList<>();
                List<Component> lexemes = new ArrayList<>();

                for (int k = 0; k < sentence.getCountOfChildren(); k++) {
                    Component lexeme = sentence.getChild(k);
                    lexemesToSort.add(lexeme);
                    lexemes.add(lexeme);
                }
                lexemes.forEach(sentence::remove);

                lexemesToSort.sort(new WordComparator());
                lexemesToSort.forEach(sentence::add);
            }
        }
        return text;
    }
}
