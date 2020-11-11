package by.training.parser.service;

import java.util.ArrayList;
import java.util.List;


public class SentenceParser extends Parser {

    public SentenceParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(List<String> strings) {
        strings.get(0);
        logger.info("Parsing of sentences");
        List<String> sentences = new ArrayList<>();
    }
}
