package by.training.parser.controller.command;

import by.training.parser.controller.Command;
import by.training.parser.controller.Receiver;
import by.training.parser.entity.CommandType;

public class SortParagraphsCommand implements Command {
    private Receiver receiver;

    public SortParagraphsCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.SORT_PARAGRAPHS);
    }
}

