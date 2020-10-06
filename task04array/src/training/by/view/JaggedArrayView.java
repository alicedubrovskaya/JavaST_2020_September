package training.by.view;

import training.by.controller.JaggedArrayController;

import java.util.Scanner;

public class JaggedArrayView {
    private JaggedArrayController jaggedArrayController;
    private Scanner in;

    public JaggedArrayView(JaggedArrayController jaggedArrayController) {
        this.jaggedArrayController = jaggedArrayController;
        in = new Scanner(System.in);


    }
}
