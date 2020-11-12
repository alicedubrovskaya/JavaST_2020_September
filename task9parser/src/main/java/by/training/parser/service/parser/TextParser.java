package by.training.parser.service.parser;

import by.training.parser.entity.Component;

public class TextParser extends Parser {

    @Override
    public void parse(String string, Component component) {
        logger.info("Parsing of text");
        chain(string, component);
    }
}