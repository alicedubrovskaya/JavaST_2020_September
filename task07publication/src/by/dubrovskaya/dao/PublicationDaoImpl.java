package by.dubrovskaya.dao;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Class that is an implementation of interface PublicationDao
 *
 * @author Alisa Dubrovskaya
 */
public class PublicationDaoImpl implements PublicationDao {
    private static final Logger logger = LogManager.getLogger(PublicationDaoImpl.class);

    /**
     * Reads from file with specified file path
     *
     * @param filePath
     * @return set of read books
     */

    @Override
    public List<String> readFromFile(String filePath) {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        List<String> lines = new ArrayList<>();

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\r\n");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                lines.add(line);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return lines;
    }

    @Override
    public Book readBook(Scanner in) {
        String title = in.next();
        int numberOfPages = in.nextInt();
        String publishingHouse = in.next();

        int count = in.nextInt();
        in.nextLine();
        Set<String> authors = new HashSet<>();
        for (int i = 0; i < count; i++) {
            authors.add(in.nextLine());
        }

        int yearOfPublishing = in.nextInt();
        String genre = in.next();
        return new Book(title, numberOfPages, publishingHouse, authors, yearOfPublishing, genre);
    }

    @Override
    public Journal readJournal(Scanner in) {
        String title = in.next();
        int numberOfPages = in.nextInt();
        String publishingHouse = in.next();
        int count = in.nextInt();
        in.nextLine();
        Set<String> authors = new HashSet<>();
        for (int i = 0; i < count; i++) {
            authors.add(in.nextLine());
        }

        int foundationDate = in.nextInt();
        String periodicity = in.next();
        return new Journal(title, numberOfPages, publishingHouse, authors, periodicity, foundationDate);
    }

    /**
     * Writes exemplar of class Publication to file.
     * If the file is indicated to be empty, file clears and writing starts from the
     * beginning of the file
     *
     * @param publication
     * @param emptyFile
     */
    @Override
    public void writeToFile(Publication publication, boolean emptyFile) {
        //TODO
        String absoluteFilePath = new File("task07publication/data/result.txt").getAbsolutePath();
        try (FileWriter writer = new FileWriter(absoluteFilePath, !emptyFile)) {
            writer.write(publication.toString());
            writer.append("\n");
            logger.debug("Publication was wrote to file");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
