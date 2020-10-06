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
        return "JaggedArray[jaggedArrayInt=" + Arrays.toString(jaggedArrayInt) + "]";
    }

    public int[][] getJaggedArrayInt() {
        return jaggedArrayInt;
    }
}
