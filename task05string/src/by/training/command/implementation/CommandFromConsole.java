package by.training.command.implementation;

import by.training.command.Receiver;
import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandFromConsole implements StringCommand {
    private StringReceiver receiver;

    public CommandFromConsole(StringReceiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.action(1);
    }
}
