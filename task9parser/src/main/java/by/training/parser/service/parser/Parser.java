package by.training.parser.service.parser;

import by.training.parser.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that represents lexeme parser
 */
public abstract class Parser {
    private Parser next;
    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    public Parser() {
    }

    public Parser(Parser next) {
        this.next = next;
    }

    /**
     * Parsers string
     *
     * @param string
     * @param component
     */
    public abstract void parse(String string, Component component);

    /**
     * Links with other components (goes to next component if it exists)
     * @param string
     * @param component
     */
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
