package by.training.command;

import by.training.command.implementation.command.*;

/**
 * Class is responsible for initializing the interface Command with it's implementation
 *
 * @author Alisa Dubrovskaya
 */
public class TextClient {
    private TextReceiver textReceiver;

    public TextClient(TextReceiver textReceiver) {
        this.textReceiver = textReceiver;
    }

    /**
     * Inits interface Command with interface implementation
     * @param option
     * @return exemplar of interface Command
     */
    public TextCommand initCommand(int option) {
        TextCommand command = null;
        switch (option) {
            case 1:
                command = new CommandFromConsole(textReceiver);
                break;
            case 2:
                command = new CommandFromFile(textReceiver);
                break;
            case 3:
                command=new CommandReplaceWithCharacter(textReceiver);
                break;
            case 4:
                command=new CommandFixIncorrectLetters(textReceiver);
                break;
            case 5:
                command=new CommandReplaceWordsOfSpecifiedLength(textReceiver);
                break;
            case 6:
                command=new CommandWordsWithoutConsonants(textReceiver);
                break;
            default:
        }
        return command;
    }
}
