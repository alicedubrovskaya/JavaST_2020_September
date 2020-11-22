package by.training.parser.controller;

import by.training.parser.controller.command.*;
import by.training.parser.entity.CommandType;

/**
 * Class is responsible for initializing the interface Command with it's implementation
 *
 * @author Alisa Dubrovskaya
 */
public class Client {
    private Receiver receiver;

    public Client(Receiver receiver) {
        this.receiver = receiver;
    }

    public Command initCommand(CommandType option) {
        Command command = null;
        switch (option) {
            case PARSE:
                command = new ParseCommand(receiver);
                break;
            case LOAD:
                command = new LoadDataCommand(receiver);
                break;
            case SORT_LEXEMES:
                command = new SortLexemesCommand(receiver);
                break;
            case SORT_WORDS:
                command = new SortWordsCommand(receiver);
                break;
            case SORT_PARAGRAPHS:
                command = new SortParagraphsCommand(receiver);
            case RECOVER:
                command = new RecoverCommand(receiver);
                break;
            default:
        }
        return command;
    }
}
