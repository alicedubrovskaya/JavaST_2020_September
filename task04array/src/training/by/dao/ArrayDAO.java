package training.by.dao;

import java.io.IOException;

public interface ArrayDAO {
    int[] getElementsFromFile(String fileName) throws IOException;
}
