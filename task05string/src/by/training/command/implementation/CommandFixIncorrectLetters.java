package by.training.command.implementation;

import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandFixIncorrectLetters implements StringCommand {
    private StringReceiver receiver;

    public CommandFixIncorrectLetters(StringReceiver receiver) {
        this.receiver=receiver;
    }

    @Override
    public void execute() {
        receiver.action(4);
    }
}


