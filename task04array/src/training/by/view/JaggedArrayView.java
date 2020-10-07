package training.by.view;

import training.by.controller.JaggedArrayController;
import training.by.exception.ElementNotFoundException;

import java.util.*;

public class JaggedArrayView {
    private JaggedArrayController jaggedArrayController;
    private Scanner in;
    private ResourceBundle rb;

    public JaggedArrayView(JaggedArrayController jaggedArrayController, ResourceBundle rb) {
        this.jaggedArrayController = jaggedArrayController;
        in = new Scanner(System.in);
        this.rb = rb;

        int option = -1;
        while (option != 0) {
            System.out.println(rb.getString("jaggedArray.menu"));
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
                    optionPrintMatrixById();
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
        System.out.println(rb.getString("jaggedArray.generate"));
        jaggedArrayController.createNewArray(in.nextInt(), in.nextInt());
    }

    protected void optionGetElementsFromConsole() {
        System.out.print(rb.getString("jaggedArray.fromConsole"));
        int countOfRows = in.nextInt();
        int[][] array = new int[countOfRows][];
        in.nextLine();

        for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
            array[currentRow] = jaggedArrayController.parseStringToIntegerElements(in.nextLine());
        }
        try {
            jaggedArrayController.createNewArray(array);
        } catch (InputMismatchException e) {
            System.out.println(rb.getString("data.incorrectType"));
        }
    }

    //TODO to add filepath from console
    protected void optionGetElementsFromFile() {
        System.out.println(rb.getString("jaggedArray.fromFile"));
        jaggedArrayController.createNewArrayFromFile();
    }


    protected void optionFindElementInArray() {
        System.out.print(rb.getString("jaggedArray.findElement"));
        try {
            System.out.print(jaggedArrayController.findPositionOfElement(in.nextInt(), in.nextInt()).toString());
        } catch (ElementNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    protected void optionFindMinAndMaxElement() {
        System.out.println(rb.getString("jaggedArray.id"));
        Map<String, Integer> values = jaggedArrayController.findMinAndMaxValue(in.nextInt());
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    protected void optionAddition() {
        System.out.println(rb.getString("jaggedArray.ids"));
        optionPrintMatrix(jaggedArrayController.additionOfTwoMatrices(in.nextInt(), in.nextInt()));
    }

    protected void optionSubtraction() {
        System.out.println(rb.getString("jaggedArray.ids"));
        optionPrintMatrix(jaggedArrayController.subtractionOfTwoMatrices(in.nextInt(), in.nextInt()));
    }

    protected void optionPrintMatrixById() {
        System.out.println(rb.getString("jaggedArray.id"));
        System.out.println(jaggedArrayController.printMatrix(in.nextInt()).toString());
    }

    protected void optionMultiplyByConstant() {
        System.out.println(rb.getString("jaggedArray.id") + ", " + rb.getString("jaggedArray.constant"));
        optionPrintMatrix(jaggedArrayController.multiplyByConstant(in.nextInt(), in.nextInt()));
    }

    protected void optionTransposeMatrix() {
        System.out.println(rb.getString("jaggedArray.id"));
        optionPrintMatrix(jaggedArrayController.transposeMatrix(in.nextInt()));
    }

    protected void optionSortBySumsOfElementsInRows() {
        System.out.println(rb.getString("jaggedArray.id") + ", " + rb.getString("jaggedArray.sort"));
        optionPrintMatrix(jaggedArrayController.sortBySumsOfElementsInRows(in.nextInt(), in.nextInt() == 1));
    }

    protected void optionSortByMaxElementsInRows() {
        System.out.println(rb.getString("jaggedArray.id") + ", " + rb.getString("jaggedArray.sort"));
        int id = jaggedArrayController.sortByMaxElementsInRows(in.nextInt(), in.nextInt() == 1);
        System.out.println("id: " + id);
    }

    protected void optionSortByMinElementsInRows() {
        System.out.println(rb.getString("jaggedArray.id") + ", " + rb.getString("jaggedArray.sort"));
        int id = jaggedArrayController.sortByMinElementsInRows(in.nextInt(), in.nextInt() == 1);
        System.out.println("id: " + id);
    }

    protected void optionPrintMatrix(int[][] matrix) {
        String array = "";
        for (int[] ints : matrix) {
            array += Arrays.toString(ints) + "\n";
        }
        System.out.println(array);
    }
}
