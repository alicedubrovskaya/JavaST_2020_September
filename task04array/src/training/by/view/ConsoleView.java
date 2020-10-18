package training.by.view;

import training.by.controller.ArrayController;
import training.by.controller.JaggedArrayController;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleView {

    public ConsoleView(ArrayController arrayController, JaggedArrayController jaggedArrayController) {
        Scanner in = new Scanner(System.in);
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
        ResourceBundle rb = ResourceBundle.getBundle("property.array", current);
        String s1 = rb.getString("console.array");

        System.out.println(s1);

        switch (in.nextInt()) {
            case 1:
                new ArrayView(arrayController, rb);
                break;
            case 2:
                new JaggedArrayView(jaggedArrayController, rb);
                break;
        }

    }
}
