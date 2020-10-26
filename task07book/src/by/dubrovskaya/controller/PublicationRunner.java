package by.dubrovskaya.controller;

import by.dubrovskaya.view.PublicationView;

public class PublicationRunner {

    public static void main(String[] args) {
        PublicationController publicationController = new PublicationController();
        new PublicationView(publicationController);
    }
}