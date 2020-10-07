package training.by.view;

import training.by.controller.ArrayController;
import training.by.exception.ElementNotFoundException;

import java.util.*;


public class ArrayView {
    private ArrayController arrayController;
    private Scanner in;
    private ResourceBundle rb;

    public ArrayView(ArrayController arrayController, ResourceBundle rb) {
        this.arrayController = arrayController;
        in = new Scanner(System.in);
        this.rb = rb;

        System.out.println(rb.getString("console.initialization"));

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

        while (option != 0) {
            System.out.println(rb.getString("array.menu"));
            option = in.nextInt();
            switch (option) {
                case 1:
                    optionFindElementInArray();
                    break;
                case 2:
                    optionFindMinAndMaxElement();
                    break;
                case 3:
                    optionSortWithBubbleSort();
                    break;
                case 4:
                    optionSortWithSelectionSort();
                    break;
                case 5:
                    optionSortWithInsertionSort();
                    break;
                case 6:
                    optionFindElement();
                    break;
                case 7:
                    optionFindPrimeNumbers();
                    break;
                case 8:
                    optionFindFibonacciNumbers();
                    break;
                case 9:
                    optionFindNumbersWithoutSameDigits();
                    break;
            }
        }

    }

    protected void optionGenerateElements() {
        System.out.print(rb.getString("array.size"));
        arrayController.createNewArray(in.nextInt());
    }

    protected void optionGetElementsFromConsole() {
        System.out.print(rb.getString("array.elements"));
        try {
            arrayController.createNewArray(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        } catch (InputMismatchException e) {
            System.out.println(rb.getString("data.incorrectType"));
        }
    }

    protected void optionGetElementsFromFile() {
        arrayController.createNewArrayFromFile();
    }

    protected void optionFindElementInArray() {
        System.out.print(rb.getString("array.value"));
        try {
            System.out.print(arrayController.findElementInArray(in.nextInt()));
        } catch (ElementNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    protected void optionFindMinAndMaxElement() {
        Map<String, Integer> values = arrayController.findMinAndMaxValue();
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    protected void optionSortWithBubbleSort() {
        System.out.println(Arrays.toString(arrayController.sortArrayWithBubbleSort()));
    }

    protected void optionSortWithSelectionSort() {
        System.out.println(Arrays.toString(arrayController.sortArrayWithSelectionSort()));
    }

    protected void optionSortWithInsertionSort() {
        System.out.println(Arrays.toString(arrayController.sortArrayWithInsertionSort()));
    }

    protected void optionFindElement() {
        System.out.print(rb.getString("array.value"));
        System.out.println(arrayController.searchElementWithBinarySearch(in.nextInt()));
    }

    protected void optionFindPrimeNumbers() {
        System.out.println(arrayController.findPrimeNumbersInArray().toString());
    }

    protected void optionFindFibonacciNumbers() {
        System.out.println(arrayController.findFibonacciNumbersInArray().toString());
    }

    protected void optionFindNumbersWithoutSameDigits() {
        System.out.println(arrayController.findNumbersWithoutSameDigits().toString());
    }
}
