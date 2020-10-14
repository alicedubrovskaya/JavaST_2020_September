package by.training.serviсe;

import java.io.IOException;

/**
 * Interface for creating text, getting words. Type of words is char[]
 *
 * @author Alisa Dubrovskaya
 */
public interface MemoryCharService {
    char[][] getWords();

    void saveText(char[][] words);

    String getFromFile(String fileName) throws IOException;

}
