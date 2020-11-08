package by.dubrovskaya.thread.dao;

import java.util.List;

/**
 * Interface that works with files
 *
 * @author Alisa Dubrovskaya
 */
public interface FiledDao {
    List<String> readFromFile(String filePath);
}
