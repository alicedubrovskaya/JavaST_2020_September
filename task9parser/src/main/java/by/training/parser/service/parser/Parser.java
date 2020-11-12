package by.training.parser.service.parser;

import by.training.parser.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Parser {
    private Parser next;
    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    public Parser() {
    }

    public abstract void parse(String string, Component component);

    public void chain(String string, Component component) {
        if (next == null) {
            logger.debug("Next parser doesn't exist");
        } else {
            next.parse(string, component);
        }
    }

    public void setNext(Parser next) {
        this.next = next;
    }
}
