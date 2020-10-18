package training.by.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JaggedArrayList {
    List<JaggedArray> jaggedArrays = new ArrayList<>();

    public int getSize() {
        return jaggedArrays.size();
    }

    public JaggedArray getArray(int position) {
        return jaggedArrays.get(position);
    }

    public void add(JaggedArray jaggedArray) {
        jaggedArrays.add(jaggedArray);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jaggedArrays);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        JaggedArrayList other = (JaggedArrayList) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && this.jaggedArrays.equals(other.jaggedArrays);
    }

    @Override
    public String toString() {
        return "JaggedArrayList[jaggedArrays=" + jaggedArrays.toString() + "]";
    }
}
