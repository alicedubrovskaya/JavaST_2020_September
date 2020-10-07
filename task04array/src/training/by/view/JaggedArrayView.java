package training.by.view;

import training.by.controller.JaggedArrayController;
import training.by.exception.ElementNotFoundException;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class JaggedArrayView {
    private JaggedArrayController jaggedArrayController;
    private Scanner in;
    private final static int MAX_VALUE_OF_ROWS = 200;

    public JaggedArrayView(JaggedArrayController jaggedArrayController) {
        this.jaggedArrayController = jaggedArrayController;
        in = new Scanner(System.in);

        int option = -1;
        while (option != 0) {
            System.out.println("\n1 - generate elements \n2 - enter elements from console \n3 - get elements from file" +
                    "\n4 - print matrix" +
                    "\n5- find element in array \n6- find min and max elements" +
                    "\n7- addition \n8- subtraction \n9- multiplyByConstant \n10- transposeMatrix" +
                    "\n11- sort by sums of elements in rows" +
                    "\n12- sort by max elements in rows \n13-sort by min elements in rows");
            option = in.nextInt();
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
                case 4:
                    optionPrintMatrix();
                    break;

                case 5:
                    optionFindElementInArray();
                    break;
                case 6:
                    optionFindMinAndMaxElement();
                    break;
                case 7:
                    optionAddition();
                    break;
                case 8:
                    optionSubtraction();
                    break;
                case 9:
                    optionMultiplyByConstant();
                    break;
                case 10:
                    optionTransposeMatrix();
                    break;
                case 11:
                    optionSortBySumsOfElementsInRows();
                    break;
                case 12:
                    optionSortByMaxElementsInRows();
                    break;
                case 13:
                    optionSortByMinElementsInRows();
                    break;
            }
        }
    }

    protected void optionGenerateElements() {
        System.out.println("Enter row and column size");
        jaggedArrayController.createNewArray(in.nextInt(), in.nextInt());
    }

    protected void optionGetElementsFromConsole() {
        System.out.print("Enter number of rows and array: ");
        int countOfRows = in.nextInt();
        int array[][] = new int[countOfRows][];

        for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
            if (currentRow != countOfRows - 1) {
                in.nextLine(); //for correct input
            }
            array[currentRow] = jaggedArrayController.parseStringToIntegerElements(in.nextLine());
        }
        try {
            jaggedArrayController.createNewArray(array);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect type of entered elements");
        }
    }

    //TODO to add filepath from console
    protected void optionGetElementsFromFile() {
        jaggedArrayController.createNewArrayFromFile();
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

    protected void optionAddition() {
        System.out.println("Enter id of matrices: ");
        int id = jaggedArrayController.additionOfTwoMatrices(in.nextInt(), in.nextInt());
        System.out.println("id: " + id);
    }

    protected void optionSubtraction() {
        System.out.println("Enter id of matrices: ");
        int id = jaggedArrayController.subtractionOfTwoMatrices(in.nextInt(), in.nextInt());
        System.out.println("id: " + id);
    }

    protected void optionPrintMatrix() {
        System.out.println("Enter id of matrix: ");
        System.out.println(jaggedArrayController.printMatrix(in.nextInt()).toString());
    }

    protected void optionMultiplyByConstant() {
        System.out.println("Enter id of matrix, constant: ");
        int id = jaggedArrayController.multiplyByConstant(in.nextInt(), in.nextInt());
        System.out.println("id: " + id);
    }

    protected void optionTransposeMatrix() {
        System.out.println("Enter id of matrix: ");
        int id = jaggedArrayController.transposeMatrix(in.nextInt());
        System.out.println("id: " + id);
    }

    protected void optionSortBySumsOfElementsInRows() {
        System.out.println("Enter id of matrix, ascending (1) or descending(2): ");
        int id = jaggedArrayController.sortBySumsOfElementsInRows(in.nextInt(), in.nextInt() == 1);
        System.out.println("id: " + id);
    }

    protected void optionSortByMaxElementsInRows() {
        System.out.println("Enter id of matrix, ascending (1) or descending(2): ");
        int id = jaggedArrayController.sortByMaxElementsInRows(in.nextInt(), in.nextInt() == 1);
        System.out.println("id: " + id);
    }

    protected void optionSortByMinElementsInRows() {
        System.out.println("Enter id of matrix, ascending (1) or descending(2): ");
        int id = jaggedArrayController.sortByMinElementsInRows(in.nextInt(), in.nextInt() == 1);
        System.out.println("id: " + id);
    }
}
