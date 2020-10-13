package by.training.command.implementation.command;

import by.training.command.TextCommand;
import by.training.command.TextReceiver;

public class CommandWordsWithoutConsonants implements TextCommand {
    private TextReceiver receiver;

    public CommandWordsWithoutConsonants(TextReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(6);
    }
}
