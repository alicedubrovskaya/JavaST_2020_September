package by.training.controller;

import by.training.command.TextClient;
import by.training.command.TextCommand;
import by.training.command.TextInvoker;
import by.training.command.TextReceiver;
import by.training.command.implementation.receiver.CharReceiverImpl;
import by.training.command.implementation.receiver.StringReceiverImpl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TextRunner {
    public static void main(String[] args) {
        final String CHAR = "CHAR";
        final String STRING = "STRING";

        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");

        TextReceiver receiver;

        System.out.println("1 — английский \n2 — русский ");
        String country = "US";
        String language = "en";
        switch (in.nextInt()) {
            case 1:
                country = "US";
                language = "en";
                break;
            case 2:
                country = "RU";
                language = "ru";
                break;
            default:
        }
        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);

        in.nextLine();
        String work = in.nextLine();
        if (CHAR.equals(work)) {
            CharArrayController charArrayController = new CharArrayController();
            receiver = new CharReceiverImpl(charArrayController,rb);
        } else {
            StringController stringController = new StringController(in.nextLine());
            receiver = new StringReceiverImpl(stringController, rb);
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
            System.out.println(rb.getString("menu"));
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
