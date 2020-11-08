package by.dubrovskaya.thread.view;

import by.dubrovskaya.thread.entity.CommandType;
import by.dubrovskaya.thread.view.command.*;

/**
 * Class is responsible for initializing the interface Command with it's implementation
 *
 * @author Alisa Dubrovskaya
 */
public class Client {
    private Receiver receiver;

    public Client(Receiver receiver) {
        this.receiver = receiver;
    }

    public Command initCommand(CommandType option) {
        Command command = null;
        switch (option) {
            case LOAD_MATRIX:
                command = new LoadMatrixCommand(receiver);
                break;
            case INITIALIZE_DIAGONAL:
                command = new InitializeDiagonalCommand(receiver);
                break;
            case SUM_OF_ELEMENTS:
                command = new SumOfElementsCommand(receiver);
                break;
            case INIT_THREADS:
                command = new InitThreads(receiver);
                break;
            default:
        }
        return command;
    }
}
