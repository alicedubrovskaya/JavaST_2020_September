package training.by.view;

import training.by.controller.JaggedArrayController;

import java.util.InputMismatchException;
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
              //  optionGetElementsFromConsole();
                break;
            case 3:
            //    optionGetElementsFromFile();
                break;
        }



    }
    protected void optionGenerateElements() {
        System.out.println("Enter row and column size");
        jaggedArrayController.createNewArray(in.nextInt(),in.nextInt());
    }
/*
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


 */
}
