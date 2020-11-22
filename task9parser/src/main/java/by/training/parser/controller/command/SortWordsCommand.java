package by.training.parser.controller.command;

import by.training.parser.controller.Command;
import by.training.parser.controller.Receiver;
import by.training.parser.entity.CommandType;

public class SortWordsCommand implements Command {
    private Receiver receiver;

    public SortWordsCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.SORT_WORDS);
    }
}

