package by.training.controller;

import by.training.command.TextClient;
import by.training.command.TextCommand;
import by.training.command.TextInvoker;
import by.training.command.TextReceiver;
import by.training.command.implementation.receiver.CharReceiverImpl;
import by.training.command.implementation.receiver.StringReceiverImpl;

import java.util.Scanner;

public class StringRunner {
    public static void main(String[] args) {
        final String CHAR = "char";
        final String STRING="string";

        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");

        CharArrayController charArrayController = new CharArrayController();
        StringController stringController=new StringController();

        //default
        TextReceiver receiver=new StringReceiverImpl(stringController);
        String work = in.nextLine();
        if (CHAR.equals(work)){
            receiver=new CharReceiverImpl(charArrayController);
        }
        else if (STRING.equals(work)){
            receiver=new StringReceiverImpl(stringController);
        }

        TextClient client = new TextClient(receiver);

        TextCommand command = client.initCommand(1);
        TextInvoker invokerTextFromConsole = new TextInvoker(command);

        command = client.initCommand(2);
        TextInvoker invokerTextFromFile = new TextInvoker(command);

        command = client.initCommand(3);
        TextInvoker invokerReplaceWithCharacter = new TextInvoker(command);

        command = client.initCommand(4);
        TextInvoker invokerFixIncorrectLetters = new TextInvoker(command);

        command = client.initCommand(5);
        TextInvoker invokerReplaceWordsOfSpecifiedLength = new TextInvoker(command);

        command = client.initCommand(6);
        TextInvoker invokerWordsWithoutConsonantsAtTheBeginning = new TextInvoker(command);

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
