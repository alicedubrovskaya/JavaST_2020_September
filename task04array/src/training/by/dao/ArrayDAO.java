package training.by.dao;

import training.by.entity.Array;
import training.by.entity.JaggedArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayDAO {
    int[] getElementsFromFile(String fileName) throws IOException;

    Array getArray();

    List<JaggedArray> getJaggedArrayList();

    void createArrayWithElementsFromFile();

    void createArray(Integer... elements);

    void createArray(int[][] arrayInt);

    //TODO
    void createJaggedArrayWithElementsFromFile();
}
