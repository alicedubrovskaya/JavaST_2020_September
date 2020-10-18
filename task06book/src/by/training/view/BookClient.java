package by.training.view;

import by.training.entity.TypeCommand;
import by.training.view.command.DeleteCommand;
import by.training.view.command.GetCommand;
import by.training.view.command.NewBookCommand;

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
                command=new DeleteCommand(bookReceiver);
                break;
            case GET:
                command=new GetCommand(bookReceiver);
                break;
            default:
        }
        return command;
    }
}
