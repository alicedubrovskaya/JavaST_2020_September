package by.training.command;

import by.training.command.implementation.*;

/**
 * Class is responsible for initializing the interface Command with it's implementation
 *
 * @author Alisa Dubrovskaya
 * @since 01.10.20
 */
public class Client {
    private Receiver receiver;

    public Client(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Inits interface Command with interface implementation
     *
     * @param option
     * @return exemplar of interface Command
     */
    public Command initCommand(int option) {
        Command command = null;
        switch (option) {
            case 1:
                command = new CommandOne(receiver);
                break;
            case 2:
                command = new CommandTwo(receiver);
                break;
            case 3:
                command = new CommandThree(receiver);
                break;
            case 4:
                command = new CommandFour(receiver);
                break;
            case 5:
                command = new CommandFive(receiver);
                break;
            case 6:
                command = new CommandSix(receiver);
                break;
            case 7:
                command = new CommandSeven(receiver);
                break;
            case 8:
                command = new CommandEight(receiver);
                break;
        }
        return command;
    }
}
