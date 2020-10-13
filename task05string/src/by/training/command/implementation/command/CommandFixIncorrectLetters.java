package by.training.command.implementation.command;

import by.training.command.TextCommand;
import by.training.command.TextReceiver;

public class CommandFixIncorrectLetters implements TextCommand {
    private TextReceiver receiver;

    public CommandFixIncorrectLetters(TextReceiver receiver) {
        this.receiver=receiver;
    }

    @Override
    public void execute() {
        receiver.action(4);
    }
}


