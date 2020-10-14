package by.training.command.implementation.receiver;

import by.training.command.TextReceiver;
import by.training.controller.CharArrayController;

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
        this.rb=resourceBundle;
    }

    public void action(int option) {

        switch (option) {
            case 1:
                textFromConsole();
                break;
            case 2:
                textFromFile();
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

    protected void printWords(char[][] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                System.out.println(words[i]);
            } else {
                break;
            }
        }
    }

    protected void textFromConsole() {
        System.out.println(rb.getString("enter.string"));
        charArrayController.saveText(in.nextLine());
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    protected void textFromFile() {
        System.out.println(rb.getString("enter.filepath"));
        charArrayController.saveFromFile(in.nextLine());
    }

    protected void optionReplaceWithCharacter() {
        System.out.println(rb.getString("enter.symbol")+", k");
        char[][] result = charArrayController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0), in.nextInt());
        printWords(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println(rb.getString("enter.fix"));
        char[][] result = charArrayController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0));
        printWords(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println(rb.getString("enter.length")+", "+rb.getString("enter.wordToBePlaced"));
        int length = in.nextInt();
        in.nextLine();
        char[] array = in.nextLine().toCharArray();
        char[][] result = charArrayController.replaceWordsOfSpecifiedLength(length, array);
        printWords(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        char[][] result = charArrayController.wordsWithoutConsonantsAtTheBeginning();
        printWords(result);
    }
}
