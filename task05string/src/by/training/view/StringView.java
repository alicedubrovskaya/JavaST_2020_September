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

        System.out.println("1 - replace needed letters with character \n2 - fix incorrect letters" +
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


    protected void optionReplaceWithCharacter() {
        System.out.println("Enter character, k");
        char character = in.next().charAt(0);
        int k = in.nextInt();
        in.nextLine();
        char[][] result = stringController.replaceNeededLettersWithAGivenCharacter(character, k,
                stringController.parseStringToArrayOfWords(in.nextLine().toCharArray()));
        printWords(result);
    }

    protected void optionFixIncorrectLetters() {
        System.out.println("Enter preceding, incorrect, needed, string");
        char preceding = in.next().charAt(0);
        char incorrect = in.next().charAt(0);
        char needed = in.next().charAt(0);
        in.nextLine();
        char[][] result = stringController.fixIncorrectLetters(preceding, incorrect, needed,
                stringController.parseStringToArrayOfWords(in.nextLine().toCharArray()));
        printWords(result);
    }

    protected void optionReplaceWordsOfSpecifiedLength() {
        System.out.println("Enter length of replacing words, word to be replaced, string");
        int length = in.nextInt();
        in.nextLine();
        char[] word = in.nextLine().toCharArray();
        char[] string = in.nextLine().toCharArray();

        char[][] result = stringController.replaceWordsOfSpecifiedLength(length, word,
                stringController.parseStringToArrayOfWords(string));
        printWords(result);
    }

    protected void optionWordsWithoutConsonantsAtTheBeginning() {
        System.out.println("Enter string:");
        in.nextLine();
        char[][] result = stringController.wordsWithoutConsonantsAtTheBeginning(
                stringController.parseStringToArrayOfWords(in.nextLine().toCharArray()));
        printWords(result);
    }
}
