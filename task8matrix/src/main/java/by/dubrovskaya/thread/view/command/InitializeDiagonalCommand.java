package by.dubrovskaya.thread.view.command;

import by.dubrovskaya.thread.entity.CommandType;
import by.dubrovskaya.thread.view.Command;
import by.dubrovskaya.thread.view.Receiver;

public class InitializeDiagonalCommand implements Command {
    private Receiver receiver;

    public InitializeDiagonalCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.INITIALIZE_DIAGONAL);
    }
}