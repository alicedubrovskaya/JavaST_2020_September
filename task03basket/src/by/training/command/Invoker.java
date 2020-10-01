package by.training.command;

/**
 * Class is responsible for invocation of command execution
 *
 * @author Alisa Dubrovskaya
 * @since 01.10.2020
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * Invokes execution of a command
     */
    public void invokeCommand() {
        command.execute();
    }
}
