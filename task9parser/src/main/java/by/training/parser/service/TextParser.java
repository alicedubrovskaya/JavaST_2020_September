package by.training.parser.service;

import java.util.List;

public class TextParser extends Parser {

    public TextParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(List<String> strings) {
        logger.info("Parsing of text");
    }
}