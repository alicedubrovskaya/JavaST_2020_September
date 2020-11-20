package by.training.parser.service.parser;

import by.training.parser.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser extends Parser {
    private static final String FIND_SYMBOLS = "(?!\\t)(?!\n)(?!\\s).";

    public SymbolParser() {
        super();
    }

    public SymbolParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string, Component component) {
        logger.info("Parsing to symbols: {}", string);

        Pattern pattern = Pattern.compile(FIND_SYMBOLS);
        Matcher match = pattern.matcher(string);
        Composite composite = null;

        if (component instanceof WordComposite) {
            composite = (WordComposite) component;
        } else if (component instanceof PunctuationMarkComposite) {
            composite = (PunctuationMarkComposite) component;
        } else return;

        while (match.find()) {
            String symbol = string.substring(match.start(), match.end());
            logger.debug("Found symbol : {}", symbol);
            SymbolLeaf symbolLeaf = new SymbolLeaf(symbol.charAt(0));
            composite.add(symbolLeaf);
            chain(symbol, symbolLeaf);
        }
    }
}
