package by.dubrovskaya.view;

import by.dubrovskaya.controller.BookController;
import by.dubrovskaya.entity.enumeration.TypeCommand;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BookView {
    private Scanner in = new Scanner(System.in);

    public BookView(BookController bookController) {
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