package by.training.controller;

import by.training.command.Client;
import by.training.command.Command;
import by.training.command.Invoker;
import by.training.command.Receiver;
import by.training.entity.list.BasketList;
import by.training.service.BallService;
import by.training.service.BasketService;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BasketList basketList = new BasketList();

        BasketService basketService = new BasketService(basketList);
        BallService ballService = new BallService(basketService);

        BasketController basketController = new BasketController(basketService, ballService);
        BallController ballController = new BallController(ballService);

        Receiver receiver = new Receiver(basketController, ballController);
        Client client = new Client(receiver);

        Command commandOne = client.initCommand(1);
        Invoker invokerOne = new Invoker(commandOne);
        Command commandTwo = client.initCommand(2);
        Invoker invokerTwo = new Invoker(commandTwo);
        Command commandThree = client.initCommand(3);
        Invoker invokerThree = new Invoker(commandThree);
        Command commandFour = client.initCommand(4);
        Invoker invokerFour = new Invoker(commandFour);
        Command commandFive = client.initCommand(5);
        Invoker invokerFive = new Invoker(commandFive);
        Command commandSix = client.initCommand(6);
        Invoker invokerSix = new Invoker(commandSix);
        Command commandSeven = client.initCommand(7);
        Invoker invokerSeven = new Invoker(commandSeven);
        Command commandEight = client.initCommand(8);
        Invoker invokerEight = new Invoker(commandEight);


        int doOptions = 1;
        while (doOptions == 1) {
            invokerEight.invokeCommand();
            int option = in.nextInt();
            switch (option) {
                case 0:
                    doOptions = 0;
                    break;
                case 1:
                    invokerOne.invokeCommand();
                    break;
                case 2:
                    invokerTwo.invokeCommand();
                    break;
                case 3:
                    invokerThree.invokeCommand();
                    break;
                case 4:
                    invokerFour.invokeCommand();
                    break;
                case 5:
                    invokerFive.invokeCommand();
                    break;
                case 6:
                    invokerSix.invokeCommand();
                    break;
                case 7:
                    invokerSeven.invokeCommand();
                    break;
            }
        }

    }
}
