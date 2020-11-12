package by.training.parser.service;

/**
 * Interface for work with file
 */
public interface FileService {
    /**
     * Reads text from file
     * @param filePath
     * @return text in string
     */
    String read(String filePath);
}
