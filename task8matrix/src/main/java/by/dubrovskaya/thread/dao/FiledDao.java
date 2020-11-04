package by.dubrovskaya.thread.dao;

import java.util.List;

public interface FiledDao {
    List<String> readFromFile(String filePath);
}
