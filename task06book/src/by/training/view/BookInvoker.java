package by.training.view;

public class BookInvoker {
    private BookCommand command;

    public BookInvoker(BookCommand command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
