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

        System.out.println("1 - replace needed letters with character \n2 - fix incorrect letters" +
                "\n3 - parse string to array of words");

        switch (in.nextInt()) {
            case 1:
                optionReplaceWithCharacter();
                break;
            case 2:
                optionFixIncorrectLetters();
                break;
            case 3:
                optionParseStringToArrayOfWords();
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

    protected void optionParseStringToArrayOfWords() {
        System.out.println("Enter string");
        in.useDelimiter("\n");
        in.nextLine();
        printWords(stringController.parseStringToArrayOfWords(in.nextLine().toCharArray()));
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

}
