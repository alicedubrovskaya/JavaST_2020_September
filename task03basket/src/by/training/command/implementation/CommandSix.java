package by.training.command.implementation;

import by.training.command.Command;
import by.training.command.Receiver;

/**
 * Class implements interface Command
 *
 * @author Alisa Dubrovskaya
 * @since 01.10.20
 */
public class CommandSix implements Command {
    private Receiver receiver;

    public CommandSix(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(6);
    }
}
