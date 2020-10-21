package by.training.controller;

import by.training.entity.enumeration.TypeCommand;
import by.training.view.BookClient;
import by.training.view.BookCommand;
import by.training.view.BookInvoker;
import by.training.view.BookReceiver;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BookRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //TODO move to view
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

        BookController bookController = new BookController();
        BookReceiver receiver = new BookReceiver(bookController, rb);
        BookClient client = new BookClient(receiver);

        BookCommand commandNewBook = client.initCommand(TypeCommand.NEW_BOOK);
        BookInvoker invokerNewBook = new BookInvoker(commandNewBook);
        BookInvoker invokerDelete = new BookInvoker(client.initCommand(TypeCommand.DELETE));
        BookInvoker invokerLoad = new BookInvoker(client.initCommand(TypeCommand.LOAD));
        BookInvoker invokerFind = new BookInvoker(client.initCommand(TypeCommand.FIND));
        BookInvoker invokerSort = new BookInvoker(client.initCommand(TypeCommand.SORT));

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
                    invokerDelete.invokeCommand();
                    break;
                case 3:
                    invokerLoad.invokeCommand();
                    break;
                case 4:
                    invokerFind.invokeCommand();
                    break;
                case 5:
                    invokerSort.invokeCommand();
                    break;
                default:
            }
        }
    }
}