package by.dubrovskaya.dao;

import by.dubrovskaya.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Class that is an implementation of interface BookDao
 *
 * @author Alisa Dubrovskaya
 */
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LogManager.getLogger(BookDaoImpl.class);

    /**
     * Reads from file with specified file path
     * @param filePath
     * @return  set of read books
     */
    @Override
    public Set<Book> readFromFile(String filePath) {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        Set<Book> books = new HashSet<>();

        String title = null;
        int numberOfPages = 0;
        int yearOfPublishing = 0;
        String publishingHouse = null;

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.equals("*")) {
                    Set<String> authors = new HashSet<>();
                    title = in.nextLine();
                    numberOfPages = Integer.valueOf(in.nextLine());
                    yearOfPublishing = Integer.valueOf(in.nextLine());
                    publishingHouse = in.nextLine();

                    int count = Integer.valueOf(in.nextLine());
                    for (int i = 0; i < count; i++) {
                        authors.add(in.nextLine());
                    }
                    Book book = new Book(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
                    logger.debug(String.format("Read from file book:%s", book.toString()));
                    books.add(book);

                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return books;
    }

    /**
     * Writes exemplar of class Book to file. If the file is indicated to be empty, file clears and writing starts from the
     * beginning of the file
     * @param book
     * @param emptyFile
     */
    @Override
    public void writeToFile(Book book, boolean emptyFile) {
        String absoluteFilePath = new File("task06book/data/result.txt").getAbsolutePath();
        try(FileWriter writer = new FileWriter(absoluteFilePath, !emptyFile)){
            writer.write(book.toString());
            writer.append("\n");
            logger.debug("Book was wrote to file");
        }
        catch (IOException e){
            logger.error(e.getMessage());
        }
    }
}
