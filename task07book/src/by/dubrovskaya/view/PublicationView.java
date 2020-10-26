package by.dubrovskaya.view;

import by.dubrovskaya.controller.PublicationController;
import by.dubrovskaya.entity.enumeration.TypeCommand;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PublicationView {
    private Scanner in = new Scanner(System.in);

    public PublicationView(PublicationController publicationController) {
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
        ResourceBundle rb = ResourceBundle.getBundle("property.book", current);

        PublicationReceiver receiver = new PublicationReceiver(publicationController, rb);
        PublicationClient client = new PublicationClient(receiver);

        PublicationCommand commandNewBook = client.initCommand(TypeCommand.NEW_BOOK);
        PublicationInvoker invokerNewBook = new PublicationInvoker(commandNewBook);
        PublicationInvoker invokerNewJournal= new PublicationInvoker(client.initCommand(TypeCommand.NEW_JOURNAL));
        PublicationInvoker invokerDelete = new PublicationInvoker(client.initCommand(TypeCommand.DELETE));
        PublicationInvoker invokerLoad = new PublicationInvoker(client.initCommand(TypeCommand.LOAD));
        PublicationInvoker invokerFind = new PublicationInvoker(client.initCommand(TypeCommand.FIND));
        PublicationInvoker invokerSort = new PublicationInvoker(client.initCommand(TypeCommand.SORT));

        int doOptions = 1;
        while (doOptions == 1) {
            System.out.println(rb.getString("menu.main"));
            int option = in.nextInt();
            switch (option) {
                case 0:
                    doOptions = 0;
                    break;
                case 1:
                    invokerNewBook.invokeCommand();
                    break;
                case 2:
                    invokerNewJournal.invokeCommand();
                    break;
                case 3:
                    invokerDelete.invokeCommand();
                    break;
                case 4:
                    invokerLoad.invokeCommand();
                    break;
                case 5:
                    invokerFind.invokeCommand();
                    break;
                case 6:
                    invokerSort.invokeCommand();
                    break;
                default:
            }
        }
    }
}