package by.training.controller;

import by.training.view.StringView;

public class StringRunner {
    public static void main(String[] args) {
        StringController stringController = new StringController();
        new StringView(stringController);
    }
}
