package training.by.service;

import training.by.entity.Array;
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

    JaggedArray arithmeticOperationOnMatrices(int idFirstMatrix, int idSecondMatrix, boolean addition) throws MatricesAreIncompatibleException;

    JaggedArray multiplyByConstant(int id, int constant);

    JaggedArray transpose(int id) throws MatrixCannotBeTransposedException;

    int [] sumOfElementsInRows(JaggedArray array);

    int []  maxElementsInRows(JaggedArray array);

    int [] minElementsInRows(JaggedArray array);

}
