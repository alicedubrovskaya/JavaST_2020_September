package by.training.command;

import by.training.controller.StringController;

import java.util.Scanner;

public class StringReceiver {
    private StringController stringController;
    private Scanner in=new Scanner(System.in);

    public StringReceiver(StringController stringController) {
        this.stringController = stringController;
        this.in.useDelimiter("\n");
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
                for (int j = 0; j < words[i].length; j++) {
                    System.out.print(words[i][j]);
                }
                System.out.println();
            } else {
                break;
            }
        }
    }

    protected void textFromConsole() {
        //TODO
        System.out.println("Enter string:");
        char [] array=in.nextLine().toCharArray();
        stringController.saveText(array);
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    protected void textFromFile() {
        System.out.println("Enter filePath: ");
        stringController.saveText(in.nextLine());
    }

    protected void optionReplaceWithCharacter() {
        System.out.println("Enter character, k");
        char[][] result = stringController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0), in.nextInt());
        printWords(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println("Enter preceding, incorrect, needed");
        char[][] result = stringController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0));
        printWords(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println("Enter length of replacing words, word to be replaced");
        int length = in.nextInt();
        in.nextLine();
        char [] array = in.nextLine().toCharArray();
        char[][] result = stringController.replaceWordsOfSpecifiedLength(length, array);
        printWords(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        char[][] result = stringController.wordsWithoutConsonantsAtTheBeginning();
        printWords(result);
    }
}