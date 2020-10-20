package by.training.controller;

import by.training.entity.TypeCommand;
import by.training.view.BookClient;
import by.training.view.BookCommand;
import by.training.view.BookInvoker;
import by.training.view.BookReceiver;

import java.util.Scanner;

public class BookRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BookController bookController = new BookController();
        BookReceiver receiver = new BookReceiver(bookController);
        BookClient client = new BookClient(receiver);

        BookCommand commandNewBook = client.initCommand(TypeCommand.NEW_BOOK);
        BookInvoker invokerNewBook = new BookInvoker(commandNewBook);
        BookInvoker invokerDelete = new BookInvoker(client.initCommand(TypeCommand.DELETE));
        BookInvoker invokerGet = new BookInvoker(client.initCommand(TypeCommand.GET));
        BookInvoker invokerLoad = new BookInvoker(client.initCommand(TypeCommand.LOAD));
        BookInvoker invokerFind = new BookInvoker(client.initCommand(TypeCommand.FIND_BY_TITLE));

        int doOptions = 1;
        while (doOptions == 1) {
            System.out.println("1 - add book, 2 - delete book, 3 - get book, 4 - load, 5 - find by title");
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
                    invokerGet.invokeCommand();
                    break;
                case 4:
                    invokerLoad.invokeCommand();
                    break;
                case 5:
                    invokerFind.invokeCommand();
                    break;
                default:
            }
        }
    }
}