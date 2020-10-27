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
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

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
    public Set<Publication> readFromFile(String filePath) {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        Set<Publication> publications = new HashSet<>();

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\r\n");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.equals("*")) {
                    PublicationType type = PublicationType.getEnum(in.nextLine());
                    Optional<Publication> publication;
                    switch (type) {
                        case BOOK:
                            publication = Optional.ofNullable(readBook(in));
                            break;
                        case JOURNAL:
                            publication = Optional.ofNullable(readJournal(in));
                            break;
                        default:
                            publication = Optional.empty();
                    }

                    if (publication.isPresent()) {
                        logger.debug(String.format("Read from file publication:%s", publication.get().toString()));
                        publications.add(publication.get());
                    }
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return publications;
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
