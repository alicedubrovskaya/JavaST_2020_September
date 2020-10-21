package by.training.view;

import by.training.entity.enumeration.TypeCommand;
import by.training.view.command.*;

/**
 * Class is responsible for initializing the interface Command with it's implementation
 *
 * @author Alisa Dubrovskaya
 */
public class BookClient {
    private BookReceiver bookReceiver;

    public BookClient(BookReceiver bookReceiver) {
        this.bookReceiver = bookReceiver;
    }

    public BookCommand initCommand(TypeCommand option) {
        BookCommand command = null;
        switch (option) {
            case NEW_BOOK:
                command = new NewBookCommand(bookReceiver);
                break;
            case DELETE:
                command = new DeleteCommand(bookReceiver);
                break;
            case LOAD:
                command = new LoadCommand(bookReceiver);
                break;
            case FIND:
                command = new FindByTagCommand(bookReceiver);
                break;
            case SORT:
                command=new SortByTagCommand(bookReceiver);
                break;
            default:
        }
        return command;
    }
}
