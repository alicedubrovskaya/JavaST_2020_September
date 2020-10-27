package by.dubrovskaya.view.command;

import by.dubrovskaya.entity.enumeration.TypeCommand;
import by.dubrovskaya.view.PublicationCommand;
import by.dubrovskaya.view.PublicationReceiver;

public class DeleteCommand implements PublicationCommand {
    private PublicationReceiver receiver;

    public DeleteCommand(PublicationReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.DELETE);
    }
}
