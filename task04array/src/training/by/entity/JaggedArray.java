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
    private int id;

    public JaggedArray(int[][] jaggedArrayInt, int id) {
        this.id = id;
        this.jaggedArrayInt = jaggedArrayInt;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        JaggedArray other = (JaggedArray) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Arrays.equals(this.getJaggedArrayInt(), other.getJaggedArrayInt());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getJaggedArrayInt());
    }

    @Override
    public String toString() {
        String array = "";
        for (int row = 0; row < jaggedArrayInt.length; row++) {
            array +=Arrays.toString(jaggedArrayInt[row])+"\n";
        }
        return "JaggedArray[jaggedArrayInt=\n" + array + "]";
    }

    public int[][] getJaggedArrayInt() {
        return jaggedArrayInt;
    }

    public int getId() {
        return id;
    }
}
