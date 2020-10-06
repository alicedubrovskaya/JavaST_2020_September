package training.by.entity;

import java.util.ArrayList;
import java.util.List;

public class JaggedArrayList {
    List<JaggedArray> jaggedArrays=new ArrayList<>();

    public List<JaggedArray> getJaggedArrays() {
        return jaggedArrays;
    }

    public void add(JaggedArray jaggedArray) {
        jaggedArrays.add(jaggedArray);
    }
}
