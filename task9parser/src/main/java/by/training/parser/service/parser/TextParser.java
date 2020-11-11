package by.training.parser.service.parser;

public class TextParser extends Parser {
    private static final String SPLIT_TO_SENTENCES = "(\\.|\\.{3}|!|\\?|\\?!)\\s";

    public TextParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string) {
        logger.info("Parsing to sentences");

        String[] result = string.split(SPLIT_TO_SENTENCES);
        for (String res : result) {
            chain(res);
        }
    }
}