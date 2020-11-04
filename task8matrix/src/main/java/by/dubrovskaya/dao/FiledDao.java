package by.dubrovskaya.dao;

import java.util.List;

public interface FiledDao {
    List<String> readFromFile(String filePath);
}
