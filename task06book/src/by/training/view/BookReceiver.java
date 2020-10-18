package by.training.view;

import by.training.controller.BookController;
import by.training.entity.TypeCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookReceiver {
    private BookController bookController;
    private Scanner in;

    public BookReceiver(BookController bookController) {
        this.bookController = bookController;
        in = new Scanner(System.in);
        in.useDelimiter("\n");
    }

    public void action(TypeCommand option) {
        switch (option) {
            case NEW_BOOK:
                optionCreateNewBook();
                break;
            case DELETE:
                optionDelete();
                break;
            case GET:
                optionGetBook();
                break;
            default:
        }
    }

    /**
     * Creates new book
     */
    private void optionCreateNewBook() {
        System.out.println("Enter title, number of pages, year of publishing, publishing house");
        String title = in.next();
        int numberOfPages = in.nextInt();
        int yearOfPublishing = in.nextInt();
        String publishingHouse = in.next();

        //TODO whithout count
        int count = in.nextInt();
        in.nextLine();
        List<String> authors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            authors.add(in.nextLine());
        }
        bookController.createNewBook(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
    }

    private void optionDelete() {
        System.out.println("Enter title");
        bookController.deleteBook(in.next());
    }

    private void optionGetBook() {
        System.out.println("Title: ");
        System.out.println(bookController.getBook(in.next()).toString());
    }
}
