package by.training.entity.data;

import java.util.ArrayList;
import java.util.List;

public class AuthorList {
    List<String> authors = new ArrayList<>();

    public void add(String author){
        authors.add(author);
    }

    public boolean authorExists(String author){
        return authors.contains(author);
    }
}
