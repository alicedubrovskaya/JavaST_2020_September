package training.by.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * CLass describes entity Array. Has overridden methods from the class Object
 *
 * @author Alisa Dubrovskaya
 * @since 02/10/20
 */
public class Array implements Cloneable {
    private int arrayInt[];

    public Array(Integer... elements) {
        arrayInt = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arrayInt[i] = elements[i];
        }
    }

    public Array(int size) {
        arrayInt = new int[size];
    }

    public Array(int[] array) {
        arrayInt = array;
    }

    public int getLength() {
        return arrayInt.length;
    }

    public int getElement(int i) {
        return arrayInt[i];
    }

    public void setElement(int i, int value) {
        arrayInt[i] = value;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Array other = (Array) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Arrays.equals(this.arrayInt, other.arrayInt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.arrayInt);
    }

    @Override
    public String toString() {
        return "Array[arrayInt=" + Arrays.toString(arrayInt) + "]";
    }

    public Array clone() throws CloneNotSupportedException {
        return (Array) super.clone();
    }
}
