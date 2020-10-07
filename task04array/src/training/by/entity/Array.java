package training.by.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * CLass describes entity Array. Has overridden methods from the class Object
 *
 * @author Alisa Dubrovskaya
 * @since 02/10/20
 */
public class Array {
    private int arrayInt[];

    public Array(Integer... elements) {
        arrayInt = new int[5];
        for (int i = 0; i < elements.length; i++) {
            arrayInt[i] = elements[i];
        }
    }

    public Array(int[] array) {
        arrayInt = array;
    }

    public int[] getArrayInt() {
        return arrayInt;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Array other = (Array) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Arrays.equals(this.getArrayInt(), other.getArrayInt());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getArrayInt());
    }

    @Override
    public String toString() {
        return "Array[arrayInt=" + Arrays.toString(arrayInt) + "]";
    }
}
