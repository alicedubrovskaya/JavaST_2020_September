package by.training.parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.ParagraphComposite;
import by.training.parser.entity.TextComposite;

public class ParagraphParser extends Parser {

    private static final String SPLIT_TO_PARAGRAPHS = "\\s{4}|\\t";
    private static final String EMPTY_LINE = "";

    @Override
    public void parse(String string, Component component) {
        logger.info("Parsing to paragraphs: {}", string);

        String[] result = string.split(SPLIT_TO_PARAGRAPHS);

        if (component instanceof TextComposite) {
            TextComposite text = (TextComposite) component;
            for (String res : result) {
                if (!EMPTY_LINE.equals(res)) {
                    logger.debug("Found paragraph: {}", res);
                    ParagraphComposite paragraph = new ParagraphComposite();
                    text.add(paragraph);
                    chain(res.trim(), paragraph);
                }
            }
        }
    }
}
