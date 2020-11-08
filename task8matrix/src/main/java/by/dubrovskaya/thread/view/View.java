package by.dubrovskaya.thread.view;

import by.dubrovskaya.thread.controller.MatrixController;
import by.dubrovskaya.thread.entity.CommandType;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class View {
    private Scanner in = new Scanner(System.in);

    public View(MatrixController matrixController) {
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
        ResourceBundle rb = ResourceBundle.getBundle("property.matrix", current);

        Receiver receiver = new Receiver(matrixController, rb);
        Client client = new Client(receiver);

        Invoker invokerLoadMatrix = new Invoker(client.initCommand(CommandType.LOAD_MATRIX));
        Invoker invokerInitDiagonal = new Invoker(client.initCommand(CommandType.INITIALIZE_DIAGONAL));
        Invoker invokerSum = new Invoker(client.initCommand(CommandType.SUM_OF_ELEMENTS));
        Invoker invokerInitThreads = new Invoker(client.initCommand(CommandType.INIT_THREADS));


        int doOptions = 1;
        while (doOptions == 1) {
            System.out.println(rb.getString("menu.main"));
            int option = in.nextInt();
            switch (option) {
                case 0:
                    doOptions = 0;
                    break;
                case 1:
                    invokerLoadMatrix.invokeCommand();
                    break;
                case 2:
                    invokerInitDiagonal.invokeCommand();
                    break;
                case 3:
                    invokerSum.invokeCommand();
                    break;
                case 4:
                    invokerInitThreads.invokeCommand();
                    break;

                default:
            }
        }
    }
}