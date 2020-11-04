package by.dubrovskaya.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDaoImpl implements FiledDao {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    /**
     * Reads from file with specified file path
     *
     * @param filePath
     * @return list of read lines from file
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
}
