package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.MemoryService;

import java.io.IOException;
import java.util.List;

/**
 * Class is an implementation of interface MemoryService.
 * This class does operations (creating text, getting words) with lines.
 *
 * @author Alisa Dubrovskaya
 */
public class MemoryServiceImpl implements MemoryService {
    private WordDAO wordDAO;

    public MemoryServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
    }

    /**
     * Gets words from memory
     *
     * @return array of lines
     */
    @Override
    public List<String> getLines() {
        return wordDAO.getText().getLines();
    }

    /**
     * Saves words to text
     *
     * @param lines
     */
    @Override
    public void saveText(List<String> lines) {
        wordDAO.createText(lines);
    }

    /**
     * Gets words from file
     *
     * @param fileName
     * @return words in string
     * @throws IOException
     */
    @Override
    public String getFromFile(String fileName) throws IOException {
        return wordDAO.getTextFromFile(fileName);
    }
}
