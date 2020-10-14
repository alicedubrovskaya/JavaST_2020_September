package by.training.serviсe;

import java.io.IOException;

public interface MemoryCharService {
    char[][] getWords();

    void saveText(char[][] words);

    String getFromFile(String fileName) throws IOException;

}
