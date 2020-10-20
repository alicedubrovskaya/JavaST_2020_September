package by.training.view;

import by.training.entity.TypeCommand;
import by.training.view.command.*;

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
            case GET:
                command = new GetCommand(bookReceiver);
                break;
            case LOAD:
                command = new LoadCommand(bookReceiver);
                break;
            case FIND_BY_TITLE:
                command = new FindByTitleCommand(bookReceiver);
                break;
            default:
        }
        return command;
    }
}
