package by.dubrovskaya.view.command;

import by.dubrovskaya.entity.enumeration.TypeCommand;
import by.dubrovskaya.view.PublicationCommand;
import by.dubrovskaya.view.PublicationReceiver;

public class FindByTagCommand implements PublicationCommand {
    private PublicationReceiver receiver;

    public FindByTagCommand(PublicationReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(TypeCommand.FIND);
    }
}
