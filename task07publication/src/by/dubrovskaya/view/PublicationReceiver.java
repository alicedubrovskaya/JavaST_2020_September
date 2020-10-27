package by.dubrovskaya.view;

import by.dubrovskaya.controller.PublicationController;
import by.dubrovskaya.entity.enumeration.TypeCommand;

import java.util.*;

/**
 * This interface is responsible for executing requests sent with the command
 *
 * @author Alisa Dubrovskaya
 */
public class PublicationReceiver {
    private PublicationController publicationController;
    private Scanner in;
    private ResourceBundle rb;

    public PublicationReceiver(PublicationController publicationController, ResourceBundle rb) {
        this.publicationController = publicationController;
        in = new Scanner(System.in);
        in.useDelimiter("\n");
        this.rb = rb;
    }

    public void action(TypeCommand option) {
        switch (option) {
            case NEW_BOOK:
                optionCreateNewBook();
                break;
            case NEW_JOURNAL:
                optionCreateNewJournal();
                break;
            case DELETE:
                optionDelete();
                break;
            case LOAD:
                optionLoadData();
                break;
            case FIND:
                optionFindByTag();
                break;
            case SORT:
                optionSortByTag();
                break;
            default:
        }
    }

    /**
     * Creates new book
     */
    private void optionCreateNewBook() {
        System.out.println(rb.getString("publication.info") + rb.getString("book.info"));
        String title = in.next();
        int numberOfPages = in.nextInt();
        String publishingHouse = in.next();

        int count = in.nextInt();
        in.nextLine();
        Set<String> authors = new HashSet<>();
        for (int i = 0; i < count; i++) {
            authors.add(in.nextLine());
        }

        int yearOfPublishing = in.nextInt();
        String genre = in.next();

        publicationController.createNewBook(title, numberOfPages, publishingHouse, authors, yearOfPublishing, genre);
    }

    /**
     * Creates new journal
     */
    private void optionCreateNewJournal() {
        System.out.println(rb.getString("publication.info") + rb.getString("journal.info"));
        String title = in.next();
        int numberOfPages = in.nextInt();
        String publishingHouse = in.next();
        int count = in.nextInt();
        in.nextLine();
        Set<String> authors = new HashSet<>();
        for (int i = 0; i < count; i++) {
            authors.add(in.nextLine());
        }

        int foundationDate = in.nextInt();
        String periodicity = in.next();

        publicationController.createNewJournal(title, numberOfPages, publishingHouse, authors, periodicity, foundationDate);
    }

    /**
     * Example of file path: task07publication/data/publication.txt
     */
    private void optionLoadData() {
        System.out.println(rb.getString("book.filePath"));
        publicationController.dataLoading("task07publication/data/publication.txt");
    }

    private void optionDelete() {
        System.out.println("Enter title");
        publicationController.deleteBook(in.next());
    }

    /**
     * TITLE("title"),
     * PAGES("pages"),
     * YEAR("year"),
     * AUTHORS("author"),
     * PUBLISHING_HOUSE("house"),
     * ID("id"),
     * ID_INTERVAL("interval"),
     * PHRASE_AND_LETTER("phrase and letter");
     */
    private void optionFindByTag() {
        System.out.println(rb.getString("book.tag"));
        //TODO input
        Map<String, Object> tags = new HashMap<>();
        tags.put("left", 1);
        tags.put("right", 0);
        publicationController.findByTag(in.nextLine(), tags);
    }

    private void optionSortByTag() {
        System.out.println(rb.getString("book.sort"));
        in.nextLine();
        publicationController.sortByTag(in.nextLine(), in.nextLine());
    }
}
