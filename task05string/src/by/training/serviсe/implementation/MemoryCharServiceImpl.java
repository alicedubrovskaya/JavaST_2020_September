package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.MemoryCharService;

import java.io.IOException;

public class MemoryCharServiceImpl implements MemoryCharService {
    private WordDAO wordDAO;

    public MemoryCharServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
    }

    @Override
    public void saveText(char[][] words) {
        wordDAO.createText(words);
    }

    @Override
    public String getFromFile(String fileName) throws IOException {
        return wordDAO.getTextFromFile(fileName);
    }

    @Override
    public char[][] getWords() {
        return wordDAO.getText().getWords();
    }

}
