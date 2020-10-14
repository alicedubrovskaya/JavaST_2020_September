package by.training.command.implementation.receiver;

import by.training.command.TextReceiver;
import by.training.controller.CharArrayController;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class is an implementation of interface TextReceiver
 *
 * @author Alisa Dubrovskaya
 */
public class CharReceiverImpl implements TextReceiver {
    private CharArrayController charArrayController;
    private ResourceBundle rb;
    private Scanner in = new Scanner(System.in);

    public CharReceiverImpl(CharArrayController charArrayController, ResourceBundle resourceBundle) {
        this.charArrayController = charArrayController;
        this.in.useDelimiter("\n");
        this.rb = resourceBundle;
    }

    public void action(int option) {

        switch (option) {
            case 1:
                textFromConsole();
                break;
            case 2:
                //      textFromFile();
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


    protected void textFromConsole() {
        System.out.println(rb.getString("enter.string"));
        charArrayController.saveText(getLines());
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    //TODO
   /* protected void textFromFile() {
        System.out.println(rb.getString("enter.filepath"));
        charArrayController.saveFromFile(in.nextLine());
    }

    */
    protected void optionReplaceWithCharacter() {
        System.out.println(rb.getString("enter.symbol") + ", k");
        List<String> result = charArrayController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0), in.nextInt());
        printLines(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println(rb.getString("enter.fix"));
        List<String> result = charArrayController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0));
        printLines(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println(rb.getString("enter.length") + ", " + rb.getString("enter.wordToBePlaced"));
        int length = in.nextInt();
        in.nextLine();
        char[] array = in.nextLine().toCharArray();
        List<String> result = charArrayController.replaceWordsOfSpecifiedLength(length, array);
        printLines(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        List<String> result = charArrayController.wordsWithoutConsonantsAtTheBeginning();
        printLines(result);
    }

    protected void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
