package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.MemoryStringService;

import java.io.IOException;
import java.util.List;

/**
 * Class is an implementation of interface MemoryCharService.
 * This class does operations (creating text, getting words) with words, which type is StringBuilder.
 *
 * @author Alisa Dubrovskaya
 */
public class MemoryStringServiceImpl implements MemoryStringService {
    private WordDAO wordDAO;

    public MemoryStringServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
    }

    /**
     * Gets words from memory
     *
     * @return array of words
     */
    @Override
    public List<StringBuilder> getWords() {
        return wordDAO.convertToString(wordDAO.getText().getWords());
    }

    /**
     * Saves words to text
     *
     * @param words
     */
    @Override
    public void saveText(List<StringBuilder> words) {
        wordDAO.createText(wordDAO.convert(words));
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
