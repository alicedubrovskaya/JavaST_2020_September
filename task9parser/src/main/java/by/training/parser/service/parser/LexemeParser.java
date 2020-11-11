package by.training.parser.service.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends Parser {
    private static final String FIND_PUNCTUATION_MARK = ",|:|;|-";

    public LexemeParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string) {
        logger.info("Parsing of lexeme: {}", string);

        Pattern pattern = Pattern.compile(FIND_PUNCTUATION_MARK);
        Matcher match = pattern.matcher(string);
        if (match.find()) {
            String punctuationMark = string.substring(match.start(), match.end());
            String[] words = string.split(punctuationMark);

            chain(punctuationMark);
            for (String word : words) {
                chain(word);
            }
        } else {
            chain(string);
        }
    }
}
