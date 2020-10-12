package by.training.entity;

import java.util.List;

public class Text {
    //TODO one type and methods in DAO to convert
    char[][] wordsChar;
    List<StringBuilder> wordsString;

    public Text(char[][] wordsChar) {
        this.wordsChar = wordsChar;
    }

    public Text(List<StringBuilder> wordsString) {
        this.wordsString = wordsString;
    }

    public char[][] getWordsChar() {
        return wordsChar;
    }

    public List<StringBuilder> getWordsString() {
        return wordsString;
    }
}
