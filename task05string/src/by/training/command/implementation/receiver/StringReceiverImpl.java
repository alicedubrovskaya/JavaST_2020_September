package by.training.command.implementation.receiver;

import by.training.command.TextReceiver;
import by.training.controller.StringController;

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
        this.rb=resourceBundle;
    }

    @Override
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

    protected void textFromConsole() {
        System.out.println(rb.getString("enter.string"));
        stringController.saveText(in.nextLine());
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    protected void textFromFile() {
        System.out.println(rb.getString("enter.filepath"));
        stringController.saveFromFile(in.nextLine());
    }

    protected void optionReplaceWithCharacter() {
        System.out.println(rb.getString("enter.symbol")+", k");
        List<StringBuilder> result = stringController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0), in.nextInt());
        printWords(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println(rb.getString("enter.fix"));
        List<StringBuilder> result = stringController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0));
        printWords(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println(rb.getString("enter.length")+", "+rb.getString("enter.wordToBePlaced"));
        int length = in.nextInt();
        in.nextLine();
        List<StringBuilder> result = stringController.replaceWordsOfSpecifiedLength(length, in.nextLine());
        printWords(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        List<StringBuilder> result = stringController.wordsWithoutConsonantsAtTheBeginning();
        printWords(result);
    }

    protected void printWords(List<StringBuilder> words){
        for (StringBuilder word: words){
            System.out.println(word);
        }
    }
}
