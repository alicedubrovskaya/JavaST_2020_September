package by.dubrovskaya.thread.entity;

import by.dubrovskaya.thread.entity.state.State;

import java.util.Arrays;
import java.util.Objects;

/**
 * CLass describes matrices.
 * Has overridden methods
 * Is common resource
 *
 * @author Alisa Dubrovskaya
 */
public class Matrix {
    private Element[][] matrix;

    public Matrix(int[][] values) {
        matrix = new Element[values.length][];

        for (int i = 0; i < values.length; i++) {
            matrix[i] = new Element[values[i].length];
            for (int j = 0; j < values[i].length; j++) {
                matrix[i][j] = new Element(values[i][j]);
            }
        }
    }

    public int getSize() {
        return matrix.length;
    }

    public void initializeElementState(int i, int j) {
        matrix[i][j].initialize();
    }

    public void synchronizeElementState(int i, int j) {
        matrix[i][j].synchronize();
    }

    public void setElementCurrentState(State currentElementState, int i, int j) {
        matrix[i][j].setCurrentElementState(currentElementState);
    }

    public int getElementValue(int i, int j) {
        return matrix[i][j].getValue();
    }

    public void setElementValue(int i, int j, int value) {
        matrix[i][j].setValue(value);
    }

    public State getElementState(int i, int j) {
        return matrix[i][j].getCurrentElementState();
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
