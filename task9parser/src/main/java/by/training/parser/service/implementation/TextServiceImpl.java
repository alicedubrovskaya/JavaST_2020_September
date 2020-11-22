package by.training.parser.service.implementation;

import by.training.parser.dao.DaoFactory;
import by.training.parser.dao.TextDao;
import by.training.parser.entity.Composite;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.TextService;
import by.training.parser.service.parser.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextServiceImpl implements TextService {
    private TextDao textDao;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public TextServiceImpl() {
        this.textDao = DaoFactory.getINSTANCE().getTextDao();
    }

    @Override
    public String recoverText(Composite composite) {
        return composite.recoverText();
    }

    @Override
    public void saveText(String text) {
        textDao.add(text);
    }

    @Override
    public Composite readText() {
        return textDao.get();
    }

    @Override
    public Composite parse(String text) {
        logger.info("Parsing of text");

        SymbolParser symbolParser = new SymbolParser();
        WordAndPunctuationParser wordAndPunctuationParser = new WordAndPunctuationParser();
        wordAndPunctuationParser.setNext(symbolParser);
        LexemeParser lexemeParser = new LexemeParser();
        lexemeParser.setNext(wordAndPunctuationParser);
        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setNext(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setNext(sentenceParser);
        TextParser textParser = new TextParser();
        textParser.setNext(paragraphParser);
        Composite composite = new TextComposite();

        textParser.chain(text, composite);

        return composite;
    }
}
