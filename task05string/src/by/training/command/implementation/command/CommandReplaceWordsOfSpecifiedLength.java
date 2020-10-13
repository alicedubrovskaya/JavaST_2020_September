package by.training.command.implementation.command;

import by.training.command.TextCommand;
import by.training.command.TextReceiver;

public class CommandReplaceWordsOfSpecifiedLength implements TextCommand {
    private TextReceiver receiver;

    public CommandReplaceWordsOfSpecifiedLength(TextReceiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.action(5);
    }
}
