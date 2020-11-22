package by.training.parser.service.implementation;

import by.training.parser.entity.Component;
import by.training.parser.entity.Composite;
import by.training.parser.entity.ParagraphComposite;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.SortService;
import by.training.parser.service.comparator.AlphabetComparator;
import by.training.parser.service.comparator.LexemeComparator;
import by.training.parser.service.comparator.ParagraphComparator;
import by.training.parser.service.comparator.WordComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SortServiceImpl implements SortService {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public Composite sortParagraphsByCountOfSentences(Composite text) {
        logger.info("Sorting of text paragraphs by count Of sentences");

        List<Component> paragraphs = new ArrayList<>();
        List<Component> paragraphsToSort = new ArrayList<>();
        for (int i = 0; i < text.getCountOfChildren(); i++) {
            paragraphs.add(text.getChild(i));
            paragraphsToSort.add(text.getChild(i));
        }

        paragraphs.forEach(text::remove);
        paragraphsToSort.sort(new ParagraphComparator());
        paragraphsToSort.forEach(text::add);

        return text;
    }

    @Override
    public Composite sortWordsInSentencesByLength(Composite text) {
        logger.info("Sorting of text words in sentences by length");

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

    /**
     * Sorts lexemes in text by number of occurrences of symbol and if its number equals by alphabet
     * @param text
     * @param symbol
     * @return new text composite that consists of one paragraph with sorted lexemes
     */
    @Override
    public Composite sortLexemesByOccurrencesOfSymbolAndAlphabet(Composite text, char symbol) {
        logger.info("Sorting of text lexemes by occurrences of symbol and alphabet");

        List<Component> lexemes = new ArrayList<>();
        Composite resultingParagraph = new ParagraphComposite();
        Composite resultingText = new TextComposite();
        resultingText.add(resultingParagraph);

        for (int i = 0; i < text.getCountOfChildren(); i++) {
            Component paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getCountOfChildren(); j++) {
                Component sentence = paragraph.getChild(j);

                for (int k = 0; k < sentence.getCountOfChildren(); k++) {
                    Component lexeme = sentence.getChild(k);
                    lexemes.add(lexeme);
                }
            }
        }
        lexemes.sort(new LexemeComparator(symbol).reversed().thenComparing(new AlphabetComparator()));
        lexemes.forEach(resultingParagraph::add);

        return resultingText;
    }
}