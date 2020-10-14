package by.training.command.implementation.receiver;

import by.training.command.TextReceiver;
import by.training.controller.StringController;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * Class is an implementation of interface TextReceiver
 *
 * @author Alisa Dubrovskaya
 */
public class StringReceiverImpl implements TextReceiver {
    private StringController stringController;
    private Scanner in = new Scanner(System.in);
    private ResourceBundle rb;

    public StringReceiverImpl(StringController stringController, ResourceBundle resourceBundle) {
        this.stringController = stringController;
        this.in.useDelimiter("\n");
        this.rb = resourceBundle;
    }

    @Override
    public void action(int option) {
        switch (option) {
            case 1:
                textFromConsole();
                break;
            case 2:
                //textFromFile();
                break;
            case 3:
                optionReplaceWithCharacter();
                break;
            case 4:
                optionFixIncorrectLetters();
                break;
            case 5:
                optionReplaceWordsOfSpecifiedLength();
                break;
            case 6:
                optionWordsWithoutConsonantsAtTheBeginning();
                break;
            default:
        }
    }

    protected List<String> getLines() {
        List<String> lines = new ArrayList<>();
        int count = in.nextInt();
        in.nextLine();

        for (int i = 0; i < count; i++) {
            lines.add(in.nextLine());
        }
        return lines;
    }

    /**
     * To stop entering text - press Ctrl+D
     */
    protected void textFromConsole() {
        System.out.println(rb.getString("enter.string"));
        stringController.saveText(getLines());
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    //TODO
  /*  protected void textFromFile() {
        System.out.println(rb.getString("enter.filepath"));
        stringController.saveFromFile(in.nextLine());
    }

   */
    protected void optionReplaceWithCharacter() {
        System.out.println(rb.getString("enter.symbol") + ", k");
        List<String> result = stringController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0), in.nextInt());
        printLines(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println(rb.getString("enter.fix"));
        List<String> result = stringController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0));
        printLines(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println(rb.getString("enter.length") + ", " + rb.getString("enter.wordToBePlaced"));
        int length = in.nextInt();
        in.nextLine();
        List<String> result = stringController.replaceWordsOfSpecifiedLength(length, in.nextLine());
        printLines(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        List<String> result = stringController.wordsWithoutConsonantsAtTheBeginning();
        printLines(result);
    }

    protected void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
