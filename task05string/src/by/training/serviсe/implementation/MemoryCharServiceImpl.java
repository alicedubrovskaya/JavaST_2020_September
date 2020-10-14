package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.MemoryCharService;

import java.io.IOException;

/**
 * Class is an implementation of interface MemoryCharService.
 * This class does operations (creating text, getting words) with words, which type is char[].
 *
 * @author Alisa Dubrovskaya
 */
public class MemoryCharServiceImpl implements MemoryCharService {
    private WordDAO wordDAO;

    public MemoryCharServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
    }

    /**
     * Saves words to text
     * @param words
     */
    @Override
    public void saveText(char[][] words) {
        wordDAO.createText(words);
    }

    /**
     * Gets words from file
     * @param fileName
     * @return words in string
     * @throws IOException
     */
    @Override
    public String getFromFile(String fileName) throws IOException {
        return wordDAO.getTextFromFile(fileName);
    }

    /**
     * Gets words from memory
     * @return array of words
     */
    @Override
    public char[][] getWords() {
        return wordDAO.getText().getWords();
    }

}
