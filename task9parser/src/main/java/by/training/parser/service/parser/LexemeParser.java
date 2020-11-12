package by.training.parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.LexemeComposite;
import by.training.parser.entity.SentenceComposite;

public class LexemeParser extends Parser {
    private static final String SPLIT_TO_LEXEMES = "(?<=.)+\\s+(?=.)+";
    private static final String EXTRA_SYMBOLS = "\\t|\n";
    private static final String EMPTY_LINE = "";

    @Override
    public void parse(String string, Component component) {
        logger.info("Parsing to lexemes: {}", string);

        String stringWithoutExtraSymbols = string.replaceAll(EXTRA_SYMBOLS, "");
        String[] result = stringWithoutExtraSymbols.split(SPLIT_TO_LEXEMES);

        if (component instanceof SentenceComposite) {
            SentenceComposite sentence = (SentenceComposite) component;
            for (String res : result) {

                if (!EMPTY_LINE.equals(res)) {
                    logger.debug("Found lexeme: {}", res);
                    LexemeComposite lexeme = new LexemeComposite();
                    sentence.add(lexeme);
                    chain(res.trim(), lexeme);
                }
            }
        }
    }
}
