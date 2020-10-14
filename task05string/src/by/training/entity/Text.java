package by.training.entity;

/**
 * CLass describes entity Text. Contains field words.
 *
 * @author Alisa Dubrovskaya
 */
public class Text {
    char[][] words;

    public Text(char[][] words) {
        this.words = words;
    }

    public char[][] getWords() {
        return words;
    }
}
