package by.training.parser.controller;

import by.training.parser.service.parser.LexemeParser;
import by.training.parser.service.parser.SentenceParser;
import by.training.parser.service.parser.SymbolParser;
import by.training.parser.service.parser.TextParser;

public class Runner {
    public static void main(String[] args) {
        SymbolParser symbolParser = new SymbolParser(null);
        LexemeParser lexemeParser = new LexemeParser(symbolParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        TextParser textParser = new TextParser(sentenceParser);
        textParser.parse("Hey-hey. animal - dog! Bye, bye... My opinion: this");
    }
}
