package training.by.dao;

import training.by.entity.Array;
import training.by.entity.JaggedArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface that works with data
 *
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayDAO {
    int[] getElementsFromFile(String fileName) throws IOException;

    int[][] getElementsOfJaggedArrayFromFile(String fileName) throws IOException;

    Array getArray();

    List<JaggedArray> getJaggedArrayList();

    void createArrayWithElementsFromFile();

    void createJaggedArrayWithElementsFromFile();

    void createArray(Integer... elements);

    int createArray(int[][] arrayInt);

    int[] parseStringToIntegerElements(String line);
}
