package by.training.controller;

import by.training.command.StringClient;
import by.training.command.StringCommand;
import by.training.command.StringInvoker;
import by.training.command.StringReceiver;

import java.util.Scanner;

public class StringRunner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");

        CharArrayController charArrayController = new CharArrayController();
        StringController stringController=new StringController();

        StringReceiver receiver = new StringReceiver(charArrayController, stringController);
        StringClient client = new StringClient(receiver);

        StringCommand command = client.initCommand(1);
        StringInvoker invokerTextFromConsole = new StringInvoker(command);

        command = client.initCommand(2);
        StringInvoker invokerTextFromFile = new StringInvoker(command);

        command = client.initCommand(3);
        StringInvoker invokerReplaceWithCharacter = new StringInvoker(command);

        command = client.initCommand(4);
        StringInvoker invokerFixIncorrectLetters = new StringInvoker(command);

        command = client.initCommand(5);
        StringInvoker invokerReplaceWordsOfSpecifiedLength = new StringInvoker(command);

        command = client.initCommand(6);
        StringInvoker invokerWordsWithoutConsonantsAtTheBeginning = new StringInvoker(command);

        int doOptions = 1;
        while (doOptions == 1) {
            System.out.println("\n1 - text from console \n2 - text from file \n3 - replace needed letters with character" +
                    " \n4 - fix incorrect letters \n5 - replace words of specified length" +
                    "\n6 - get words without consonants at the beginning");
            int option = in.nextInt();
            switch (option) {
                case 0:
                    doOptions = 0;
                    break;
                case 1:
                    invokerTextFromConsole.invokeCommand();
                    break;
                case 2:
                    invokerTextFromFile.invokeCommand();
                    break;
                case 3:
                    invokerReplaceWithCharacter.invokeCommand();
                    break;
                case 4:
                    invokerFixIncorrectLetters.invokeCommand();
                    break;
                case 5:
                    invokerReplaceWordsOfSpecifiedLength.invokeCommand();
                    break;
                case 6:
                    invokerWordsWithoutConsonantsAtTheBeginning.invokeCommand();
                    break;
                default:
            }
        }
    }
}
