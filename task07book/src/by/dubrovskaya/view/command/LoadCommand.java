package by.dubrovskaya.view.command;

import by.dubrovskaya.entity.enumeration.TypeCommand;
import by.dubrovskaya.view.BookCommand;
import by.dubrovskaya.view.BookReceiver;

public class LoadCommand implements BookCommand {
    private BookReceiver receiver;

    public LoadCommand(BookReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.LOAD);
    }
}
