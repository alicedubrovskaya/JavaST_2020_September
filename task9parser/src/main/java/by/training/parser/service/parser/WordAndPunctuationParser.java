package by.training.parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.LexemeComposite;
import by.training.parser.entity.PunctuationMarkComposite;
import by.training.parser.entity.WordComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndPunctuationParser extends Parser {
    private static final String PUNCTUATION_MARK = "\\.{3}|,|\\.|\\?|\\?!";
    private static final String EXTRA_SYMBOLS_FOR_WORDS = "\\t|\n|\\s{2,}|" + PUNCTUATION_MARK;
    private static final String SPLIT_TO_WORDS = "(?<=.)+\\s+(?=.)+";
    private static final String EMPTY_LINE = "";

    public WordAndPunctuationParser() {
        super();
    }

    public WordAndPunctuationParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string, Component component) {
        Pattern pattern = Pattern.compile(PUNCTUATION_MARK);
        Matcher match = pattern.matcher(string);

        if (component instanceof LexemeComposite) {
            LexemeComposite lexeme = (LexemeComposite) component;

            while (match.find()) {
                String punctuationMark = string.substring(match.start(), match.end());
                logger.debug("Found punctuation mark: {}", punctuationMark);

                PunctuationMarkComposite punctuation = new PunctuationMarkComposite();
                lexeme.add(punctuation);
                chain(punctuationMark, punctuation);
            }

            String stringWithoutExtraSymbols = string.replaceAll(EXTRA_SYMBOLS_FOR_WORDS, "");
            String[] result = stringWithoutExtraSymbols.split(SPLIT_TO_WORDS);
            for (String res : result) {
                if (!EMPTY_LINE.equals(res)) {
                    logger.debug("Found word: {}", res);
                    WordComposite word = new WordComposite();
                    lexeme.add(word);
                    chain(res.trim(), word);
                }
            }
        }
    }
}
