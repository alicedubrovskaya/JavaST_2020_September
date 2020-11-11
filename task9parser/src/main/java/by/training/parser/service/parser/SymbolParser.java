package by.training.parser.service.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser extends Parser {
    private static final String FIND_SYMBOLS = ".";

    public SymbolParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string) {
        logger.info("Parsing of word or punctuation mark to symbols: {}", string);
        Pattern pattern = Pattern.compile(FIND_SYMBOLS);
        Matcher match = pattern.matcher(string);
        List<String> symbols = new ArrayList<>();

        while (match.find()) {
            String symbol = string.substring(match.start(), match.end());
            logger.debug("Found new symbol at string: {}", symbol);
            symbols.add(symbol);
        }
    }
}
