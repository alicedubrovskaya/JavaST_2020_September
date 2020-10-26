package by.dubrovskaya.view;

/**
 * Class is responsible for invocation of command execution
 *
 * @author Alisa Dubrovskaya
 */
public class PublicationInvoker {
    private PublicationCommand command;

    public PublicationInvoker(PublicationCommand command) {
        this.command=command;
    }

    public void invokeCommand() {
        command.execute();
    }
}
