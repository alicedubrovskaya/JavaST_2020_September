package by.training.command.implementation.array;

import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandReplaceWordsOfSpecifiedLength implements StringCommand {
    private StringReceiver receiver;

    public CommandReplaceWordsOfSpecifiedLength(StringReceiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.action(5);
    }
}
