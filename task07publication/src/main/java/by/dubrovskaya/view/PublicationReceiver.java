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
            case NEW_PUBLICATION:
                optionCreateNewPublication();
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
     * Creates new publication
     */
    private void optionCreateNewPublication() {
        System.out.println(rb.getString("publication.info"));
        publicationController.createNewPublication(in.nextLine());
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
        publicationController.deletePublication(in.next());
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
        Map<String, Object> tags = new HashMap<>();
        tags.put("left", 1);
        tags.put("right", 0);
        publicationController.findByTag(in.nextLine(), tags);
    }

    private void optionSortByTag() {
        System.out.println(rb.getString("book.sort"));
        in.nextLine();
        publicationController.sortByTag("title and page", "asc");
    }
}
