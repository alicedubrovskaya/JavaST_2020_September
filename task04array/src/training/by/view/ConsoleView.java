package training.by.view;

import training.by.controller.ArrayController;

import java.util.Scanner;


public class ConsoleView {
    private ArrayController arrayController;
    private Scanner in;

    public ConsoleView(ArrayController arrayController) {
        this.arrayController = arrayController;
        in = new Scanner(System.in);

        System.out.println("1-generate elements of array\n 2-enter elements of array \n3-create array with elements from file");
        int option = in.nextInt();
        switch (option) {
            case 1:
                optionGenerateElements();
                break;
            case 2:
                optionGetElementsFromConsole();
                break;
            case 3:
                optionGetElementsFromFile();
                break;

        }

    }

    protected void optionGenerateElements() {
        arrayController.createNewArray();
    }

    protected void optionGetElementsFromConsole() {
        System.out.print("Enter 5 elements: ");
        arrayController.createNewArray(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
    }

    protected void optionGetElementsFromFile() {
        arrayController.createNewArrayFromFile();
    }
}
