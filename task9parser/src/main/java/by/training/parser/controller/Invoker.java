package by.training.parser.controller;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
