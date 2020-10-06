package training.by.view;

import training.by.controller.JaggedArrayController;
import training.by.exception.ElementNotFoundException;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class JaggedArrayView {
    private JaggedArrayController jaggedArrayController;
    private Scanner in;

    public JaggedArrayView(JaggedArrayController jaggedArrayController) {
        this.jaggedArrayController = jaggedArrayController;
        in = new Scanner(System.in);
        System.out.println("How do you want to initialize array? \n1 - generate elements \n2 - enter elements from console" +
                "\n3 - get elements from file");

        int option = in.nextInt();
        switch (option) {
            case 1:
                optionGenerateElements();
                break;
            case 2:
                optionGetElementsFromConsole();
                break;
            case 3:
                //    optionGetElementsFromFile();
                break;
        }


        while (option != 0) {
            System.out.println("\n1- find element in array \n2- find min and max elements");
            option = in.nextInt();
            switch (option) {
                case 1:
                    optionFindElementInArray();
                    break;
                case 2:
                    optionFindMinAndMaxElement();
                    break;
            }
        }
    }

    protected void optionGenerateElements() {
        System.out.println("Enter row and column size");
        jaggedArrayController.createNewArray(in.nextInt(), in.nextInt());
    }

    protected void optionGetElementsFromConsole() {
        //TODO jagged, not constant size
        System.out.print("Enter count of rows and columns: ");
        int rowCount = in.nextInt();
        int columnCount = in.nextInt();

        int[][] array = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            array[i] = new int[columnCount];
            for (int j = 0; j < columnCount; j++) {
                array[i][j] = in.nextInt();
            }
        }
        try {
            jaggedArrayController.createNewArray(array);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect type of entered elements");
        }
    }

    protected void optionFindElementInArray() {
        System.out.print("Enter id, value of element: ");
        try {
            System.out.print("Element found in position: "
                    + jaggedArrayController.findPositionOfElement(in.nextInt(), in.nextInt()).toString());
        } catch (ElementNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    protected void optionFindMinAndMaxElement() {
        System.out.println("Enter id of array");
        Map<String, Integer> values = jaggedArrayController.findMinAndMaxValue(in.nextInt());
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
/*
    protected void optionGetElementsFromFile() {
        arrayController.createNewArrayFromFile();
    }
 */


}
