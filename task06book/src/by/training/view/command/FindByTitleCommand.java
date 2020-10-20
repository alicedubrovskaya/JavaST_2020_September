package by.training.view.command;

import by.training.entity.TypeCommand;
import by.training.view.BookCommand;
import by.training.view.BookReceiver;

public class FindByTitleCommand implements BookCommand {
    private BookReceiver receiver;

    public FindByTitleCommand(BookReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.FIND_BY_TITLE);
    }
}
