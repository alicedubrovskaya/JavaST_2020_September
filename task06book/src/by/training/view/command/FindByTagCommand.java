package by.training.view.command;

import by.training.entity.enumeration.TypeCommand;
import by.training.view.BookCommand;
import by.training.view.BookReceiver;

public class FindByTagCommand implements BookCommand {
    private BookReceiver receiver;

    public FindByTagCommand(BookReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.FIND);
    }
}
