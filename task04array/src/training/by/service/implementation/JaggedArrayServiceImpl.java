package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.JaggedArray;
import training.by.service.BaseOperationsService;
import training.by.service.JaggedArrayService;

import java.util.List;

public class JaggedArrayServiceImpl implements JaggedArrayService {
    private BaseOperationsService baseOperationsService;
    private ArrayDAO arrayDAO;

    public JaggedArrayServiceImpl(BaseOperationsService baseOperationsService) {
        this.baseOperationsService = baseOperationsService;
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.arrayDAO = daoFactory.getArrayDAO();
    }

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

    @Override
    public boolean sameDimensionOfJaggedArrays(int idFirstArray, int idSecondArray) {
        int[][] firstArray = findJaggedArray(idFirstArray).getJaggedArrayInt();
        int[][] secondArray = findJaggedArray(idSecondArray).getJaggedArrayInt();
        return (firstArray.length == secondArray.length && firstArray[0].length == secondArray[0].length);
    }

    @Override
    public boolean squareMatrix(int id) {
        int[][] array = findJaggedArray(id).getJaggedArrayInt();
        return (array.length == array[0].length);
    }

    @Override
    public int[][] addition(int idFirstMatrix, int idSecondMatrix) {
        int[][] firstMatrix = findJaggedArray(idFirstMatrix).getJaggedArrayInt();
        int[][] secondMatrix = findJaggedArray(idSecondMatrix).getJaggedArrayInt();
        //TODO normal finding of size jagged array
        int[][] resultingMatrix = new int[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                resultingMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return resultingMatrix;
    }

    @Override
    public int[][] subtraction(int idFirstMatrix, int idSecondMatrix) {
        int[][] firstMatrix = findJaggedArray(idFirstMatrix).getJaggedArrayInt();
        int[][] secondMatrix = findJaggedArray(idSecondMatrix).getJaggedArrayInt();
        //TODO normal finding of size jagged array
        int[][] resultingMatrix = new int[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                resultingMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return resultingMatrix;
    }

    @Override
    public int[][] multiplyByConstant(int id, int constant) {
        int[][] matrix = findJaggedArray(id).getJaggedArrayInt();
        //TODO
        int[][] resultingMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                resultingMatrix[row][column] = matrix[row][column] * constant;
            }
        }
        return resultingMatrix;
    }

    @Override
    public int[][] transpose(int id) {
        int[][] matrix = findJaggedArray(id).getJaggedArrayInt();
        //TODO
        int[][] resultingMatrix = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                resultingMatrix[column][row] = matrix[row][column];
            }
        }
        return resultingMatrix;
    }

    @Override
    public int[] sumOfElementsInRows(int[][] array) {
        int[] sums = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sums[i]=baseOperationsService.sumOfElements(array[i]);
        }
        return sums;
    }
}
