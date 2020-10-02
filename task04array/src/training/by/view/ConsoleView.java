package training.by.view;

import training.by.controller.ArrayController;
import training.by.entity.Array;

import java.util.Scanner;


public class ConsoleView {
    private ArrayController arrayController;
    private Scanner in;

    public ConsoleView(ArrayController arrayController) {
        this.arrayController = arrayController;
        in = new Scanner(System.in);

        System.out.println("1-generate elements of array\n 2-enter elements of array");
        int option = in.nextInt();
        switch (option) {
            case 1:
                optionGenerateElements();
                break;
            case 2:
                optionGetElementsFromConsole();
                break;
        }

    }

    protected void optionGenerateElements() {
        Array array = new Array();
        int[] arrayInt = array.getArrayInt();
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i] + " ");
        }
    }

    protected void optionGetElementsFromConsole() {
        System.out.print("Enter 5 elements: ");
        arrayController.createNewArray(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
    }
}
