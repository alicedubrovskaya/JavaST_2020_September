package by.dubrovskaya.thread.entity;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getVerticalSize() {
        return matrix.length;
    }

    public int getHorizontalSize(int row) {
        return matrix[row].length;
    }

    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int[] getRow(int i) {
        return matrix[i];
    }

    public void setRow(int i, int[] array) {
        matrix[i] = array;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Matrix other = (Matrix) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Arrays.equals(this.matrix, other.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.matrix);
    }

    @Override
    public String toString() {
        String array = "";
        for (int row = 0; row < matrix.length; row++) {
            array += Arrays.toString(matrix[row]) + "\n";
        }
        return "Matrix[matrix=\n" + array + "]";
    }
}
