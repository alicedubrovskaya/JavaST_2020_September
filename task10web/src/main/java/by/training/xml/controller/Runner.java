package by.training.xml.controller;

import by.training.xml.controller.command.Client;
import by.training.xml.controller.command.Command;
import by.training.xml.controller.command.Invoker;
import by.training.xml.controller.command.Receiver;
import by.training.xml.entity.enumeration.CommandType;

public class Runner {
    public static void main(String args[]){
        Receiver receiver = new Receiver();
        Client client = new Client(receiver);

        Command command = client.initCommand(CommandType.DOM);
        Invoker invoker = new Invoker(command);
        invoker.invokeCommand();
    }
}
