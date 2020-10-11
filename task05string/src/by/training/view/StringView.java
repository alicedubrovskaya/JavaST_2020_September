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


    protected void optionReplaceWithCharacter() {
        System.out.println("Enter character, k, string");
        char[] result = stringController.replaceNeededLettersWithAGivenCharacter(in.next().charAt(0),
                in.nextInt(), in.next().toCharArray());
        for (Character element : result) {
            System.out.print(element);
        }
    }

    protected void optionFixIncorrectLetters() {
        System.out.println("Enter preceding, incorrect, needed, string");
        char[] result = stringController.fixIncorrectLetters(in.next().charAt(0), in.next().charAt(0), in.next().charAt(0),
                in.next().toCharArray());
        for (Character element : result) {
            System.out.print(element);
        }
    }

    protected void optionParseStringToArrayOfWords() {
        System.out.println("Enter string");
        in.useDelimiter("\n");
        char[] line = in.nextLine().toCharArray();

        char[][] result = stringController.parseStringToArrayOfWords(in.nextLine().toCharArray());
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            } else {
                break;
            }
        }
    }
}
