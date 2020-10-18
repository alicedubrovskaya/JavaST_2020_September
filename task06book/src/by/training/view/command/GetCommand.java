package by.training.view.command;

import by.training.entity.TypeCommand;
import by.training.view.BookCommand;
import by.training.view.BookReceiver;

public class GetCommand implements BookCommand {
    private BookReceiver receiver;

    public GetCommand(BookReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.GET);
    }
}
