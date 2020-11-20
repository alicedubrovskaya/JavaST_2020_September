package by.training.parser.service;

import by.training.parser.entity.Composite;

public interface SortService {
    Composite sortParagraphsByCountOfSentences(Composite text);

    Composite sortWordsInSentencesByLength(Composite text);

    /**
     * Descending
     */
    Composite sortLexemesByOccurrencesOfSymbolAndAlphabet(Composite text, char symbol);
}
