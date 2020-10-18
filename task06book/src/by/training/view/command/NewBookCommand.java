package by.training.view.command;

import by.training.entity.TypeCommand;
import by.training.view.BookCommand;
import by.training.view.BookReceiver;

public class NewBookCommand implements BookCommand {
    private BookReceiver receiver;

    public NewBookCommand(BookReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.NEW_BOOK);
    }
}
