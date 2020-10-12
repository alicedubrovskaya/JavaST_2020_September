package by.training.command.implementation;

import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandFromFile implements StringCommand {
    private StringReceiver receiver;

    public CommandFromFile(StringReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(2);
    }
}
