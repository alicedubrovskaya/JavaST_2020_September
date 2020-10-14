package by.training.entity;

import java.util.List;

/**
 * CLass describes entity Text. Contains field words.
 *
 * @author Alisa Dubrovskaya
 */
public class Text {
    List<String> lines;

    public Text(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }
}
