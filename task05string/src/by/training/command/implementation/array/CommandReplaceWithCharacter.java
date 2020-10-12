package by.training.command.implementation.array;

import by.training.command.StringCommand;
import by.training.command.StringReceiver;

public class CommandReplaceWithCharacter implements StringCommand {
    private StringReceiver receiver;

    public CommandReplaceWithCharacter(StringReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(3);
    }
}
