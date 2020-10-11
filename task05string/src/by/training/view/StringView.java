package by.training.view;

import by.training.controller.StringController;

import java.util.Scanner;

public class StringView {
    //TODO command pattern
    private StringController stringController;
    private Scanner in;

    public StringView(StringController stringController) {
        this.stringController = stringController;
        this.in = new Scanner(System.in);
        in.useDelimiter("\n");

        System.out.println("\n1 - text from console, 2 - text from file");

        switch (in.nextInt()) {
            case 1:
                textFromConsole();
                break;
            case 2:
                textFromFile();
                break;
            default:
        }

        System.out.println("\n1 - replace needed letters with character \n2 - fix incorrect letters" +
                "\n3 - replace words of specified length" +
                "\n4 - get words without consonants at the beginning");

        switch (in.nextInt()) {
            case 1:
                optionReplaceWithCharacter();
                break;
            case 2:
                optionFixIncorrectLetters();
                break;
            case 3:
                optionReplaceWordsOfSpecifiedLength();
                break;
            case 4:
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
        in.nextLine();
        stringController.saveText(in.nextLine().toCharArray());
    }

    /**
     * Example of file path: task05string/data/text.txt
     */
    protected  void textFromFile(){
        System.out.println("Enter filePath: ");
        in.nextLine();
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
        System.out.println("Enter length of replacing words, word to be replaced, string");
        char[][] result = stringController.replaceWordsOfSpecifiedLength(in.nextInt(), in.nextLine().toCharArray());
        printWords(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        char[][] result = stringController.wordsWithoutConsonantsAtTheBeginning();
        printWords(result);
    }
}
