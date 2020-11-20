package by.training.parser.service.implementation;

import by.training.parser.entity.Component;
import by.training.parser.entity.Composite;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.SortService;
import by.training.parser.service.comparator.ParagraphComparator;

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

    @Override
    public Composite sortWordsInSentencesByLength(Composite text) {
        return null;
    }
}
