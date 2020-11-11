package by.dubrovskaya.thread.view.command;

import by.dubrovskaya.thread.entity.CommandType;
import by.dubrovskaya.thread.view.Command;
import by.dubrovskaya.thread.view.Receiver;

public class LoadMatrixCommand implements Command {
    private Receiver receiver;

    public LoadMatrixCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.LOAD_MATRIX);
    }
}
