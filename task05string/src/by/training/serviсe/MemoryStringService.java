package by.training.serviсe;

import java.io.IOException;
import java.util.List;

public interface MemoryStringService {

    List<StringBuilder> getWords();

    void saveText(List<StringBuilder> words);

    String getFromFile(String fileName) throws IOException;

}
