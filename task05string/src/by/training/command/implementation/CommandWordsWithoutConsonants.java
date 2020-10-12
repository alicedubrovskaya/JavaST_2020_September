package by.training.command.implementation;

import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandWordsWithoutConsonants implements StringCommand {
    private StringReceiver receiver;

    public CommandWordsWithoutConsonants(StringReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(6);
    }
}
