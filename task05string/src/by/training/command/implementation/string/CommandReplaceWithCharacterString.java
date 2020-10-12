package by.training.command.implementation.string;

import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandReplaceWithCharacterString implements StringCommand {
    private StringReceiver receiver;

    public CommandReplaceWithCharacterString(StringReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(7);
    }
}