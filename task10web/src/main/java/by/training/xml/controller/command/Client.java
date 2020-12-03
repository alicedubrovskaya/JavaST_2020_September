package by.training.xml.controller.command;


import by.training.xml.controller.command.command.ParseDOMCommand;
import by.training.xml.controller.command.command.ParseSAXCommand;
import by.training.xml.controller.command.command.ParseStAXCommand;
import by.training.xml.entity.enumeration.CommandType;

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

    public Command initCommand(CommandType option) { Command command = null;
        switch (option) {
            case DOM:
                command = new ParseDOMCommand(receiver);
                break;
            case SAX:
                command = new ParseSAXCommand(receiver);
                break;
            case STAX:
                command = new ParseStAXCommand(receiver);
                break;
            default:
        }
        return command;
    }
}
