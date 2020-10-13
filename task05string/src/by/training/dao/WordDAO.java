package by.training.dao;

import by.training.entity.Text;

import java.io.IOException;
import java.util.List;

/**
 * Interface that works with data
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public interface WordDAO {
    void createText(char[][] words);

    char[][] convert(List<StringBuilder> words);

    List<StringBuilder> convertToString(char[][] words);

    Text getText();

    String getTextFromFile(String fileName) throws IOException;
}
