package by.training.command.implementation.command;

import by.training.command.TextCommand;
import by.training.command.TextReceiver;

public class CommandReplaceWithCharacter implements TextCommand {
    private TextReceiver receiver;

    public CommandReplaceWithCharacter(TextReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(3);
    }
}
