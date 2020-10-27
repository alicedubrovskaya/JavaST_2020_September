package by.dubrovskaya.view;

import by.dubrovskaya.entity.enumeration.TypeCommand;
import by.dubrovskaya.view.command.*;

/**
 * Class is responsible for initializing the interface Command with it's implementation
 *
 * @author Alisa Dubrovskaya
 */
public class PublicationClient {
    private PublicationReceiver publicationReceiver;

    public PublicationClient(PublicationReceiver publicationReceiver) {
        this.publicationReceiver = publicationReceiver;
    }

    public PublicationCommand initCommand(TypeCommand option) {
        PublicationCommand command = null;
        switch (option) {
            case NEW_BOOK:
                command = new NewPublicationCommand(publicationReceiver);
                break;
            case NEW_JOURNAL:
                command = new NewJournalCommand(publicationReceiver);
                break;
            case DELETE:
                command = new DeleteCommand(publicationReceiver);
                break;
            case LOAD:
                command = new LoadCommand(publicationReceiver);
                break;
            case FIND:
                command = new FindByTagCommand(publicationReceiver);
                break;
            case SORT:
                command = new SortByTagCommand(publicationReceiver);
                break;
            default:
        }
        return command;
    }
}
