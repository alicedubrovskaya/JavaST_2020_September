package by.training.parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.ParagraphComposite;
import by.training.parser.entity.SentenceComposite;

public class SentenceParser extends Parser {
    private static final String SPLIT_TO_SENTENCES = "(?<=[\\.\\!\\?\\.{3}\\?!])\\s";
    private static final String EXTRA_SYMBOL_PARAGRAPH = "\\t";
    private static final String EXTRA_SYMBOL= "\n";

    private static final String EMPTY_LINE = "";

    public SentenceParser() {
        super();
    }

    public SentenceParser(Parser next) {
        super(next);
    }

    @Override
    public void parse(String string, Component component) {
        logger.info("Parsing to sentences: {}", string);

        String stringWithoutExtraSymbols = string.replaceAll(EXTRA_SYMBOL, "");
        stringWithoutExtraSymbols = stringWithoutExtraSymbols.replaceAll(EXTRA_SYMBOL_PARAGRAPH, " ");
        String[] result = stringWithoutExtraSymbols.split(SPLIT_TO_SENTENCES);

        if (component instanceof ParagraphComposite) {
            ParagraphComposite paragraph = (ParagraphComposite) component;
            for (String res : result) {

                if (!EMPTY_LINE.equals(res)) {
                    logger.debug("Found sentence: {}", res);
                    SentenceComposite sentence = new SentenceComposite();
                    paragraph.add(sentence);
                    chain(res.trim(), sentence);
                }
            }
        }
    }
}
