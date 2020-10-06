package training.by.dao;

import training.by.entity.Array;

import java.io.IOException;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayDAO {
    int[] getElementsFromFile(String fileName) throws IOException;

    Array getArray();

    void createArrayWithElementsFromFile();

    void createArray(Integer... elements);

    void createArray(int[] arrayInt);
}
