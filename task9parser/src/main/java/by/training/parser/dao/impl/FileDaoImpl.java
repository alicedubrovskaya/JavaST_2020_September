package by.training.parser.dao.impl;

import by.training.parser.dao.FileDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that is an implementation of interface FileDao
 *
 * @author Alisa Dubrovskaya
 */
public class FileDaoImpl implements FileDao {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    /**
     * Reads from file with specified file path
     *
     * @param filePath
     * @return string of text
     */
    @Override
    public String read(String filePath) {
        logger.info("Reading from file");
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        StringBuilder result = new StringBuilder();

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                result.append(line + "\n");
            }
            logger.debug("Text from file read");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return result.toString();
    }
}
