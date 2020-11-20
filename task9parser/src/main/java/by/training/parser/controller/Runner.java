package by.training.parser.controller;

import by.training.parser.entity.Composite;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.SortService;
import by.training.parser.service.implementation.SortServiceImpl;
import by.training.parser.service.parser.*;

public class Runner {
    public static void main(String[] args) {
        SymbolParser symbolParser = new SymbolParser();
        WordAndPunctuationParser wordAndPunctuationParser = new WordAndPunctuationParser();
        wordAndPunctuationParser.setNext(symbolParser);
        LexemeParser lexemeParser = new LexemeParser();
        lexemeParser.setNext(wordAndPunctuationParser);
        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setNext(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setNext(sentenceParser);
        TextParser textParser = new TextParser();
        textParser.setNext(paragraphParser);
        Composite composite = new TextComposite();
        textParser.chain("My name is Frank... I am   from London.\n How   are you?\tHello...", composite);


        SortService sortService = new SortServiceImpl();
        System.out.println(sortService.
                sortWordsInSentencesByLength(composite)
                .recoverText());

//        System.out.println(sortService.sortParagraphsByCountOfSentences(composite).recoverText());

    }
}
