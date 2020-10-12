package by.training.command;

import by.training.command.implementation.*;

public class StringClient {
    private StringReceiver stringReceiver;

    public StringClient(StringReceiver stringReceiver) {
        this.stringReceiver = stringReceiver;
    }

    public StringCommand initCommand(int option) {
        StringCommand command = null;
        switch (option) {
            case 1:
                command = new CommandFromConsole(stringReceiver);
                break;
            case 2:
                command = new CommandFromFile(stringReceiver);
                break;
            case 3:
                command=new CommandReplaceWithCharacter(stringReceiver);
                break;
            case 4:
                command=new CommandFixIncorrectLetters(stringReceiver);
                break;
            case 5:
                command=new CommandReplaceWordsOfSpecifiedLength(stringReceiver);
                break;
            case 6:
                command=new CommandWordsWithoutConsonants(stringReceiver);
                break;
            default:
        }
        return command;
    }
}
