package by.dubrovskaya.thread.view.command;

import by.dubrovskaya.thread.entity.CommandType;
import by.dubrovskaya.thread.view.Command;
import by.dubrovskaya.thread.view.Receiver;

public class InitThreads implements Command {
    private Receiver receiver;

    public InitThreads(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(CommandType.INIT_THREADS);
    }
}

