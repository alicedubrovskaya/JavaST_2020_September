package by.training.xml.controller.command.command;

import by.training.xml.controller.command.Command;
import by.training.xml.controller.command.Receiver;
import by.training.xml.entity.enumeration.CommandType;

public class ParseStAXCommand implements Command {
    private Receiver receiver;

    public ParseStAXCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.STAX);
    }
}

