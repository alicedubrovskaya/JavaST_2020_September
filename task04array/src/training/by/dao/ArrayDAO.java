package training.by.dao;

import java.io.IOException;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayDAO {
    int[] getElementsFromFile(String fileName) throws IOException;
}
