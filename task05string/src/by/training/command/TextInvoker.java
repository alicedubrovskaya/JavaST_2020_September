package by.training.command;

public class TextInvoker {
    private TextCommand command;

    public TextInvoker(TextCommand command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
