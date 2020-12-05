package by.training.xml.controller.console;

import by.training.xml.entity.enumeration.CommandType;

public class Runner {
    public static void main(String args[]){
        Receiver receiver = new Receiver();
        Client client = new Client(receiver);

        Command command = client.initCommand(CommandType.SAX);
        Invoker invoker = new Invoker(command);
        invoker.invokeCommand();
    }
}
