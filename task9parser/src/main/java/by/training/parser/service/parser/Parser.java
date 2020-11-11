package by.training.parser.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Parser {
    private Parser next;
    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    public Parser(Parser next) {
        this.next = next;
    }

    public abstract void parse(String string);

    public void chain(String string) {
        if (next == null) {
            logger.debug("Next parser doesn't exist");
        } else {
            next.parse(string);
            next.chain(string);
        }
    }
}
