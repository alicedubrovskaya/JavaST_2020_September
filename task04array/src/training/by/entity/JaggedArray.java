package training.by.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * CLass describes entity JaggedArray. Has overridden methods from the class Object
 *
 * @author Alisa Dubrovskaya
 * @since 06/10/20
 */
public class JaggedArray {
    private int[][] jaggedArrayInt;

    public JaggedArray(int[][] jaggedArrayInt) {
        this.jaggedArrayInt = jaggedArrayInt;
    }

    public JaggedArray(int verticalSize) {
        this.jaggedArrayInt = new int[verticalSize][];
    }

    public JaggedArray(int verticalSize, int horizontalSize) {
        this.jaggedArrayInt = new int[verticalSize][horizontalSize];
    }

    public void initializeRow(int i, int length) {
        this.jaggedArrayInt[i] = new int[length];
    }

    public int getVerticalSize() {
        return jaggedArrayInt.length;
    }

    public int getHorizontalSize(int row) {
        return jaggedArrayInt[row].length;
    }

    public int getElement(int i, int j) {
        return jaggedArrayInt[i][j];
    }

    public void setElement(int i, int j, int value) {
        jaggedArrayInt[i][j] = value;
    }

    public int[] getRow(int i) {
        return jaggedArrayInt[i];
    }

    public void setRow(int i, int[] array) {
        jaggedArrayInt[i] = array;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        JaggedArray other = (JaggedArray) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Arrays.equals(this.jaggedArrayInt, other.jaggedArrayInt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.jaggedArrayInt);
    }

    @Override
    public String toString() {
        String array = "";
        for (int row = 0; row < jaggedArrayInt.length; row++) {
            array += Arrays.toString(jaggedArrayInt[row]) + "\n";
        }
        return "JaggedArray[jaggedArrayInt=\n" + array + "]";
    }
}
