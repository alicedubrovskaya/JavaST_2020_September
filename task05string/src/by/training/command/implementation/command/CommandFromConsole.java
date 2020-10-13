package by.training.command.implementation.command;

import by.training.command.TextCommand;
import by.training.command.TextReceiver;

public class CommandFromConsole implements TextCommand {
    private TextReceiver receiver;

    public CommandFromConsole(TextReceiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.action(1);
    }
}
