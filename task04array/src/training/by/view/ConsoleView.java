package training.by.view;

import training.by.controller.ArrayController;
import training.by.controller.JaggedArrayController;

import java.util.Scanner;

public class ConsoleView {

    public ConsoleView(ArrayController arrayController, JaggedArrayController jaggedArrayController) {
        Scanner in = new Scanner(System.in);

        System.out.println("1 - array \n2- jagged array");
        switch (in.nextInt()) {
            case 1:
                new ArrayView(arrayController);
                break;
            case 2:
                new JaggedArrayView(jaggedArrayController);
        }

    }
}
