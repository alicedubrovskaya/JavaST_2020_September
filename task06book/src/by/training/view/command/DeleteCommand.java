package by.training.view.command;

import by.training.entity.TypeCommand;
import by.training.view.BookCommand;
import by.training.view.BookReceiver;

public class DeleteCommand implements BookCommand {
    private BookReceiver receiver;

    public DeleteCommand(BookReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.DELETE);
    }
}
