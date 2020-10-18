package training.by.entity;

import java.util.List;
import java.util.Objects;

public class ArrayList {
    List<Array> arrays = new java.util.ArrayList<>();

    public Array getArray(int i) {
        return arrays.get(i);
    }

    public void addArray(Array array) {
        arrays.add(array);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        ArrayList other = (ArrayList) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && this.arrays.equals(other.arrays);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.arrays);
    }

    @Override
    public String toString() {
        return "ArrayList[arrays=" + arrays.toString() + "]";
    }

}
