package by.training.view;

import by.training.controller.BookController;
import by.training.entity.Book;
import by.training.entity.TypeCommand;

import java.util.*;

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
            case LOAD:
                optionLoadData();
                break;
            case FIND_BY_TITLE:
                optionFindByTitle();
                break;
            default:
        }
    }

    /**
     * Creates new book
     */
    private void optionCreateNewBook() {
        System.out.println("Enter title, number of pages, year of publishing, publishing house, count and authors");
        String title = in.next();
        int numberOfPages = in.nextInt();
        int yearOfPublishing = in.nextInt();
        String publishingHouse = in.next();

        //TODO whithout count
        int count = in.nextInt();
        in.nextLine();
        Set<String> authors = new HashSet<>();
        for (int i = 0; i < count; i++) {
            authors.add(in.nextLine());
        }
        bookController.createNewBook(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
    }

    /**
     * Example of file path: task06book/data/book.txt
     */
    private void optionLoadData() {
        System.out.println("Enter filePath");
        printBooks(bookController.dataLoading(in.next()));
    }

    private void optionDelete() {
        System.out.println("Enter title");
        bookController.deleteBook(in.next());
    }

    private void optionGetBook() {

    }

    private void optionFindByTitle() {
        System.out.println(bookController.findBookByTitle(in.nextLine()).toString());
    }

    private void printBooks(Set<Book> books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
