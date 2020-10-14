package by.training.command;

/**
 * Class is responsible for invocation of command execution
 *
 * @author Alisa Dubrovskaya
 */
public class TextInvoker {
    private TextCommand command;

    public TextInvoker(TextCommand command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
