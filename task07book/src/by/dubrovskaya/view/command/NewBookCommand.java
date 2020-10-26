package by.dubrovskaya.view.command;

import by.dubrovskaya.entity.enumeration.TypeCommand;
import by.dubrovskaya.view.BookCommand;
import by.dubrovskaya.view.BookReceiver;

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
