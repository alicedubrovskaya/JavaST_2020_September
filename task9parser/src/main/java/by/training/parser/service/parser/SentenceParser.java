package by.training.parser.service.parser;

public class SentenceParser extends Parser {
    private static final String SPLIT_TO_LEXEMES = "\\s";

    public SentenceParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string) {
        logger.info("Parsing of sentence {}", string);
        String[] result = string.split(SPLIT_TO_LEXEMES);
        for (String res: result){
            chain(res);
        }
    }
}
