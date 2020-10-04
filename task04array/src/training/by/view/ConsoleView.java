package training.by.view;

import training.by.controller.ArrayController;
import training.by.exception.ElementNotFoundException;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class ConsoleView {
    private ArrayController arrayController;
    private Scanner in;

    public ConsoleView(ArrayController arrayController) {
        this.arrayController = arrayController;
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
                optionGetElementsFromFile();
                break;
        }

        while (option != 0) {
            System.out.println("\n1- find element in array \n2- find min and max element \n3- bubble sort" +
                    "\n4- selection sort \n5- insertion sort \n6-binary search");
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
            }
        }

    }

    protected void optionGenerateElements() {
        arrayController.createNewArray();
    }

    protected void optionGetElementsFromConsole() {
        System.out.print("Enter 5 elements: ");
        try {
            arrayController.createNewArray(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Incorrect type of entered elements");
        }
    }

    protected void optionGetElementsFromFile() {
        arrayController.createNewArrayFromFile();
    }

    protected void optionFindElementInArray() {
        System.out.print("Enter value of element: ");
        try {
            System.out.print("Element found in position: " + arrayController.findElementInArray(in.nextInt()));
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
        System.out.print("Enter value: ");
        System.out.println(arrayController.searchElementWithBinarySearch(in.nextInt()));
    }
}
