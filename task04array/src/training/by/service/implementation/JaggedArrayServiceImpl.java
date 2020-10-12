package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.JaggedArray;
import training.by.exception.MatricesAreIncompatibleException;
import training.by.exception.MatrixCannotBeTransposedException;
import training.by.service.BaseOperationsService;
import training.by.service.JaggedArrayService;

import java.util.List;

/**
 * Class is an implementation of interface JaggedArrayService
 *
 * @author Alisa Dubrovskaya
 */
public class JaggedArrayServiceImpl implements JaggedArrayService {
    private BaseOperationsService baseOperationsService;
    private ArrayDAO arrayDAO;

    public JaggedArrayServiceImpl(BaseOperationsService baseOperationsService) {
        this.baseOperationsService = baseOperationsService;
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
        JaggedArray jaggedArray = null;
        List<JaggedArray> jaggedArrayList = arrayDAO.getJaggedArrayList();

        for (JaggedArray element : jaggedArrayList) {
            if (element.getId() == id) {
                jaggedArray = element;
            }
        }
        return jaggedArray;
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
        int[][] firstArray = findJaggedArray(idFirstArray).getJaggedArrayInt();
        int[][] secondArray = findJaggedArray(idSecondArray).getJaggedArrayInt();

        if (firstArray.length != secondArray.length) {
            isEqualDimension = false;
        } else {
            for (int row = 0; row < firstArray.length; row++) {
                if (firstArray[row].length != secondArray[row].length) {
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
        int[][] array = findJaggedArray(id).getJaggedArrayInt();
        int countOfRows = array.length;

        for (int[] ints : array) {
            if (ints.length != countOfRows) {
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
        int[][] array = findJaggedArray(id).getJaggedArrayInt();
        int countOfColumns = array[0].length;

        for (int[] ints : array) {
            if (ints.length != countOfColumns) {
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
    public int[][] arithmeticOperationOnMatrices(int idFirstMatrix, int idSecondMatrix, boolean addition)
            throws MatricesAreIncompatibleException {

        int[][] resultingMatrix;
        if (sameDimensionOfJaggedArrays(idFirstMatrix, idSecondMatrix)) {
            int[][] firstMatrix = findJaggedArray(idFirstMatrix).getJaggedArrayInt();
            int[][] secondMatrix = findJaggedArray(idSecondMatrix).getJaggedArrayInt();
            resultingMatrix = new int[firstMatrix.length][];

            for (int i = 0; i < firstMatrix.length; i++) {
                resultingMatrix[i] = new int[firstMatrix[i].length];

                for (int j = 0; j < firstMatrix[i].length; j++) {
                    if (addition) {
                        resultingMatrix[i][j] = baseOperationsService.addition(firstMatrix[i][j], secondMatrix[i][j]);
                    } else {
                        resultingMatrix[i][j] = baseOperationsService.subtraction(firstMatrix[i][j], secondMatrix[i][j]);
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
    public int[][] multiplyByConstant(int id, int constant) {
        int[][] matrix = findJaggedArray(id).getJaggedArrayInt();
        int[][] resultingMatrix = new int[matrix.length][];

        for (int row = 0; row < matrix.length; row++) {
            resultingMatrix[row] = new int[matrix[row].length];
            for (int column = 0; column < matrix[row].length; column++) {
                resultingMatrix[row][column] = matrix[row][column] * constant;
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
    public int[][] transpose(int id) throws MatrixCannotBeTransposedException {
        int[][] matrix = findJaggedArray(id).getJaggedArrayInt();

        if (rectangularMatrix(id)) {
            int[][] resultingMatrix = new int[matrix[0].length][matrix.length];

            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    resultingMatrix[column][row] = matrix[row][column];
                }
            }
            return resultingMatrix;
        } else if (squareMatrix(id)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
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
    public int[] sumOfElementsInRows(int[][] array) {
        int[] sums = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sums[i] = baseOperationsService.sumOfElements(array[i]);
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
    public int[] maxElementsInRows(int[][] array) {
        int[] maxElements = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            maxElements[i] = baseOperationsService.findMaxValue(array[i]);
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
    public int[] minElementsInRows(int[][] array) {
        int[] minElements = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            minElements[i] = baseOperationsService.findMinValue(array[i]);
        }
        return minElements;
    }
}