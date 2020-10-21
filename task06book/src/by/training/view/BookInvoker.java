package by.training.view;

/**
 * Class is responsible for invocation of command execution
 *
 * @author Alisa Dubrovskaya
 */
public class BookInvoker {
    private BookCommand command;

    public BookInvoker(BookCommand command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
