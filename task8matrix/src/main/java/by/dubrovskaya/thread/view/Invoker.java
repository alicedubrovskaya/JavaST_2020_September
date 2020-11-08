package by.dubrovskaya.thread.view;

/**
 * Class is responsible for invocation of command execution
 *
 * @author Alisa Dubrovskaya
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
