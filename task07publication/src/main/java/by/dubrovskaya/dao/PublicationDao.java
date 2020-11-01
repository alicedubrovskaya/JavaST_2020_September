package by.dubrovskaya.dao;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;

import java.util.List;
import java.util.Scanner;

/**
 * Interface that works with files
 *
 * @author Alisa Dubrovskaya
 */
public interface PublicationDao {
    List<String> readFromFile(String filePath);

    void writeToFile(Publication publication, boolean emptyFile);
}
