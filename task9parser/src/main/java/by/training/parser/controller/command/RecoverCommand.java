package by.training.parser.controller.command;

import by.training.parser.controller.Command;
import by.training.parser.controller.Receiver;
import by.training.parser.entity.CommandType;

public class RecoverCommand implements Command {
    private Receiver receiver;

    public RecoverCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.RECOVER);
    }
}

