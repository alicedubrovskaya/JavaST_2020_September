package by.training.parser.service.implementation;

import by.training.parser.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class is an implementation of interface FileService
 */
public class FileServiceImpl implements FileService {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    /**
     * Reads from file
     *
     * @param filePath
     * @return text in string
     */
    @Override
    public String read(String filePath) {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        StringBuilder result = new StringBuilder();

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            // in.useDelimiter("\r\n");
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
