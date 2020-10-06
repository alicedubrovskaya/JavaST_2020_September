package training.by.entity;

import java.util.List;

public class JaggedArrayList {
    List<JaggedArray> jaggedArrays;

    public List<JaggedArray> getJaggedArrays() {
        return jaggedArrays;
    }

    public void add(JaggedArray jaggedArray) {
        jaggedArrays.add(jaggedArray);
    }
}
