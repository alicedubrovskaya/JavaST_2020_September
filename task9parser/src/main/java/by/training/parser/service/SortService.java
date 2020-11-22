package by.training.parser.service;

import by.training.parser.entity.Composite;

/**
 * Interface for sorting
 */
public interface SortService {
    Composite sortParagraphsByCountOfSentences(Composite text);

    Composite sortWordsInSentencesByLength(Composite text);

    /**
     * Descending
     */
    Composite sortLexemesByOccurrencesOfSymbolAndAlphabet(Composite text, char symbol);
}
