package by.training.serviсe;

import java.io.IOException;
import java.util.List;

/**
 * Interface work creating text, getting lines
 *
 * @author Alisa Dubrovskaya
 */
public interface MemoryService {

    List<String> getLines();

    void saveText(List<String> words);

    List<String> getFromFile(String fileName) throws IOException;

}
