package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.Array;
import training.by.entity.JaggedArray;
import training.by.exception.MatricesAreIncompatibleException;
import training.by.exception.MatrixCannotBeTransposedException;
import training.by.service.BaseOperationsService;
import training.by.service.FindingService;
import training.by.service.JaggedArrayService;

import java.util.List;

/**
 * Class is an implementation of interface JaggedArrayService
 *
 * @author Alisa Dubrovskaya
 */
public class JaggedArrayServiceImpl implements JaggedArrayService {
    private BaseOperationsService baseOperationsService;
    private FindingService findingService;
    private ArrayDAO arrayDAO;

    public JaggedArrayServiceImpl(BaseOperationsService baseOperationsService, FindingService findingService) {
        this.baseOperationsService = baseOperationsService;
        this.findingService = findingService;
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.arrayDAO = daoFactory.getArrayDAO();
    }

    /**
     * Finds jagged array by id
     *
     * @param id
     * @return
     */
    @Override
    public JaggedArray findJaggedArray(int id) {
        return arrayDAO.getJaggedArray(id);
    }

    /**
     * Compares dimension of jagged arrays
     *
     * @param idFirstArray
     * @param idSecondArray
     * @return
     */
    @Override
    public boolean sameDimensionOfJaggedArrays(int idFirstArray, int idSecondArray) {
        boolean isEqualDimension = true;
        JaggedArray firstArray = findJaggedArray(idFirstArray);
        JaggedArray secondArray = findJaggedArray(idSecondArray);

        if (firstArray.getVerticalSize() != secondArray.getVerticalSize()) {
            isEqualDimension = false;
        } else {
            for (int row = 0; row < firstArray.getVerticalSize(); row++) {
                if (firstArray.getHorizontalSize(row) != secondArray.getHorizontalSize(row)) {
                    isEqualDimension = false;
                    break;
                }
            }
        }

        return isEqualDimension;
    }

    /**
     * Check id matrix square or not
     *
     * @param id
     * @return
     */
    @Override
    public boolean squareMatrix(int id) {
        boolean isSquare = true;
        JaggedArray array = findJaggedArray(id);
        int countOfRows = array.getVerticalSize();

        for (int i = 0; i < array.getVerticalSize(); i++) {
            if (array.getHorizontalSize(i) != countOfRows) {
                isSquare = false;
                break;
            }
        }
        return isSquare;
    }

    /**
     * Checks is matrix rectangular or not
     *
     * @param id
     * @return
     */
    @Override
    public boolean rectangularMatrix(int id) {
        boolean isSquare = true;
        JaggedArray array = findJaggedArray(id);
        int countOfColumns = array.getHorizontalSize(0);

        for (int i = 0; i < array.getVerticalSize(); i++) {
            if (array.getHorizontalSize(i) != countOfColumns) {
                isSquare = false;
                break;
            }
        }
        return isSquare;
    }


    /**
     * Does arithmetic operation on matrices: addition or subtraction, depending on needed.
     *
     * @param idFirstMatrix
     * @param idSecondMatrix
     * @param addition
     * @return new resulting matrix
     * @throws MatricesAreIncompatibleException
     */
    @Override
    public JaggedArray arithmeticOperationOnMatrices(int idFirstMatrix, int idSecondMatrix, boolean addition)
            throws MatricesAreIncompatibleException {

        JaggedArray resultingMatrix;
        if (sameDimensionOfJaggedArrays(idFirstMatrix, idSecondMatrix)) {
            JaggedArray firstMatrix = findJaggedArray(idFirstMatrix);
            JaggedArray secondMatrix = findJaggedArray(idSecondMatrix);
            resultingMatrix = new JaggedArray(firstMatrix.getVerticalSize());

            for (int i = 0; i < firstMatrix.getVerticalSize(); i++) {
                resultingMatrix.initializeRow(i, firstMatrix.getHorizontalSize(0));

                for (int j = 0; j < firstMatrix.getHorizontalSize(i); j++) {
                    if (addition) {
                        resultingMatrix.setElement(i, j,
                                baseOperationsService.addition(firstMatrix.getElement(i, j), secondMatrix.getElement(i, j)));
                    } else {
                        resultingMatrix.setElement(i, j,
                                baseOperationsService.subtraction(firstMatrix.getElement(i, j), secondMatrix.getElement(i, j)));
                    }
                }
            }
        } else {
            throw new MatricesAreIncompatibleException();
        }
        return resultingMatrix;
    }

    /**
     * Multiplies matrix by a constant
     *
     * @param id
     * @param constant
     * @return new resulting matrix
     */
    @Override
    public JaggedArray multiplyByConstant(int id, int constant) {
        JaggedArray matrix = findJaggedArray(id);
        JaggedArray resultingMatrix = new JaggedArray(matrix.getVerticalSize());

        for (int row = 0; row < matrix.getVerticalSize(); row++) {
            resultingMatrix.initializeRow(row, matrix.getHorizontalSize(row));

            for (int column = 0; column < matrix.getHorizontalSize(row); column++) {
                resultingMatrix.setElement(row, column, matrix.getElement(row, column) * constant);
            }
        }
        return resultingMatrix;
    }

    /**
     * Transposes matrix with specified id. If there is rectangular matrix creates new matrix(resulting).
     * If there is square matrix transposition does on this matrix without creation of new matrix
     *
     * @param id
     * @return transposed matrix
     * @throws MatrixCannotBeTransposedException
     */
    @Override
    public JaggedArray transpose(int id) throws MatrixCannotBeTransposedException {
        JaggedArray matrix = findJaggedArray(id);

        if (rectangularMatrix(id)) {
            JaggedArray resultingMatrix = new JaggedArray(matrix.getHorizontalSize(0), matrix.getVerticalSize());

            for (int row = 0; row < matrix.getVerticalSize(); row++) {
                for (int column = 0; column < matrix.getHorizontalSize(row); column++) {
                    resultingMatrix.setElement(column, row, matrix.getElement(row, column));
                }
            }
            return resultingMatrix;
        } else if (squareMatrix(id)) {
            for (int i = 0; i < matrix.getVerticalSize(); i++) {
                for (int j = 0; j < matrix.getHorizontalSize(i); j++) {
                    baseOperationsService.swap(matrix, i, j);
                }
            }
        } else {
            throw new MatrixCannotBeTransposedException(id);
        }
        return matrix;
    }

    /**
     * Finds sum of elements in rows of jagged array
     *
     * @param array
     * @return sum
     */
    @Override
    public int[] sumOfElementsInRows(JaggedArray array) {
        int[] sums = new int[array.getVerticalSize()];

        for (int i = 0; i < array.getVerticalSize(); i++) {
            sums[i] = findingService.sumOfElements(new Array(array.getRow(i)));
        }
        return sums;
    }

    /**
     * Finds max element in each row of jagged array
     *
     * @param array
     * @return max elements
     */
    @Override
    public int[] maxElementsInRows(JaggedArray array) {
        int[] maxElements = new int[array.getVerticalSize()];

        for (int i = 0; i < array.getVerticalSize(); i++) {
            maxElements[i] = findingService.findMaxValue(new Array(array.getRow(i)));
        }
        return maxElements;
    }

    /**
     * Finds min element in each row of jagged array
     *
     * @param array
     * @return min elements
     */
    @Override
    public int[] minElementsInRows(JaggedArray array) {
        int[] minElements = new int[array.getVerticalSize()];

        for (int i = 0; i < array.getVerticalSize(); i++) {
            minElements[i] = findingService.findMinValue(new Array(array.getRow(i)));
        }
        return minElements;
    }
}
