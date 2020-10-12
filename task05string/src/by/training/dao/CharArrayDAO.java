package by.training.dao;

import by.training.entity.Text;

import java.io.IOException;

/**
 * Interface that works with data
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public interface CharArrayDAO {
    void createText(char[][] words);
    Text getText();
    char [] getTextFromFile(String fileName) throws IOException;
}
