package training.by.service;

import training.by.entity.JaggedArray;
import training.by.exception.MatricesAreIncompatibleException;
import training.by.exception.MatrixCannotBeTransposedException;

/**
 * Interface for work with jagged array
 *
 * @author Alisa Dubrovskaya
 */
public interface JaggedArrayService {
    JaggedArray findJaggedArray(int id);

    boolean squareMatrix(int id);

    boolean rectangularMatrix(int id);

    boolean sameDimensionOfJaggedArrays(int idFirstArray, int idSecondArray);

    //TODO сleverer
    int[][] arithmeticOperationOnMatrices(int idFirstMatrix, int idSecondMatrix, boolean addition) throws MatricesAreIncompatibleException;

    int[][] multiplyByConstant(int id, int constant);

    int[][] transpose(int id) throws MatrixCannotBeTransposedException;

    int[] sumOfElementsInRows(int[][] array);

    int[] maxElementsInRows(int[][] array);

    int[] minElementsInRows(int[][] array);

}
