package by.training.command;

public class StringInvoker {
    private StringCommand command;

    public StringInvoker(StringCommand command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
