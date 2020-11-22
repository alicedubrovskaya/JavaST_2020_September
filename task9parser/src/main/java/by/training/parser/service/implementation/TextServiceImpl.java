package by.training.parser.service.implementation;

import by.training.parser.dao.DaoFactory;
import by.training.parser.dao.TextDao;
import by.training.parser.entity.Composite;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.TextService;
import by.training.parser.service.parser.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class is an implementation of interface TextService
 */
public class TextServiceImpl implements TextService {

    private TextDao textDao;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    private final SymbolParser symbolParser = SymbolParser.getINSTANCE();
    private final WordAndPunctuationParser wordAndPunctuationParser = WordAndPunctuationParser.getINSTANCE();
    private final LexemeParser lexemeParser = LexemeParser.getINSTANCE();
    private final SentenceParser sentenceParser = SentenceParser.getINSTANCE();
    private final ParagraphParser paragraphParser = ParagraphParser.getINSTANCE();
    private final TextParser textParser = TextParser.getINSTANCE();


    public TextServiceImpl() {
        this.textDao = DaoFactory.getINSTANCE().getTextDao();
    }

    /**
     * Recovers text (collects from composite to string)
     * @param composite
     * @return text in string
     */
    @Override
    public String recoverText(Composite composite) {
        return composite.recoverText();
    }

    /**
     * Saves text to storage
     * @param text
     */
    @Override
    public void saveText(String text) {
        textDao.add(text);
    }

    /**
     * Reads text from storage
     * @return
     */
    @Override
    public Composite readText() {
        return textDao.get();
    }

    /**
     * Parsers text in string to Composite chain
     * @param text
     * @return composite
     */
    @Override
    public Composite parse(String text) {
        logger.info("Parsing of text");

        wordAndPunctuationParser.setNext(symbolParser);
        lexemeParser.setNext(wordAndPunctuationParser);
        sentenceParser.setNext(lexemeParser);
        paragraphParser.setNext(sentenceParser);
        textParser.setNext(paragraphParser);
        Composite composite = new TextComposite();

        textParser.chain(text, composite);
        return composite;
    }
}
