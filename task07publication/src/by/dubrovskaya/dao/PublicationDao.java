package by.dubrovskaya.dao;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;

import java.util.Scanner;
import java.util.Set;

/**
 * Interface that works with files
 *
 * @author Alisa Dubrovskaya
 */
public interface PublicationDao {
    Set<Publication> readFromFile(String filePath);

    void writeToFile(Publication publication, boolean emptyFile);

    Book readBook(Scanner in);

    Journal readJournal(Scanner in);
}
