package by.training.xml.controller.console.command;

import by.training.xml.controller.console.Command;
import by.training.xml.controller.console.Receiver;
import by.training.xml.entity.enumeration.CommandType;

public class ParseSAXCommand implements Command {
    private Receiver receiver;

    public ParseSAXCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.SAX);
    }
}

