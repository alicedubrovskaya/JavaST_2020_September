package by.training.parser.controller;

import by.training.parser.service.SentenceParser;
import by.training.parser.service.TextParser;

import java.util.Collections;

public class Runner {
    public static void main(String[] args) {
        SentenceParser sentenceParser = new SentenceParser(null);
        TextParser textParser = new TextParser(sentenceParser);
        textParser.chain(Collections.singletonList("Hello world!"));
    }
}
