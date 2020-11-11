package by.training.parser.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Parser {
    private Parser next;
    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    public Parser(Parser next) {
        this.next = next;
    }

    public abstract void parse(List<String> strings);

    public void chain(List<String> strings) {
        parse(strings);

        if (next == null) {
            logger.debug("Next parser doesn't exist");
        } else {
            next.chain(strings);
        }
    }
}
