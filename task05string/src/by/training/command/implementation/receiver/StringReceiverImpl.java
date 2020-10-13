package by.training.command.implementation.receiver;

import by.training.command.TextReceiver;
import by.training.controller.StringController;

import java.util.List;
import java.util.Scanner;

public class StringReceiverImpl implements TextReceiver {
    private StringController stringController;
    private Scanner in = new Scanner(System.in);

    public StringReceiverImpl(StringController stringController) {
        this.stringController = stringController;
        this.in.useDelimiter("\n");
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
        System.out.println("Enter string:");
        stringController.saveText(in.nextLine());
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    protected void textFromFile() {
        //TODO another name of method in controller (the same parameters now)
        System.out.println("Enter filePath: ");
        //charArrayController.saveText(in.nextLine());
    }

    protected void optionReplaceWithCharacter() {
        System.out.println("Enter character, k");
        List<StringBuilder> result = stringController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0), in.nextInt());
        printWords(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println("Enter preceding, incorrect, needed");
        List<StringBuilder> result = stringController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0));
        printWords(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println("Enter length of replacing words, word to be replaced");
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
