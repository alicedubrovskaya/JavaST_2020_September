package training.by.service;

import training.by.entity.JaggedArray;

public interface JaggedArrayService {
    JaggedArray findJaggedArray(int id);

    boolean squareMatrix(int id);

    //TODO for jagged array
    boolean sameDimensionOfJaggedArrays(int idFirstArray, int idSecondArray);

    int [][] addition(int idFirstMatrix, int idSecondMatrix);

    int [][] subtraction(int idFirstMatrix, int idSecondMatrix);
}
