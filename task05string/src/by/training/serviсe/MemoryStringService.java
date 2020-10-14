package by.training.serviсe;

import java.io.IOException;
import java.util.List;

/**
 * Interface work creating text, getting words. Type of words is StringBuilder
 *
 * @author Alisa Dubrovskaya
 */
public interface MemoryStringService {

    List<StringBuilder> getWords();

    void saveText(List<StringBuilder> words);

    String getFromFile(String fileName) throws IOException;

}
